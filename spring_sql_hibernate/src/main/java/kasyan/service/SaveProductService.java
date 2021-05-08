package kasyan.service;

import kasyan.bean.Product;
import kasyan.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveProductService{

    private GetProductService getProductService;

    /* отправка запроса на добавление новой записи в БД Product
   и автоматическим расчетом цены с учетом скидки */
    public void save(String category, String name, double price, double discount, double totalVolume){
        List<Product> newList = getProductService.findAll();
        int id = createId(newList);
        double actualPrice = calculating(price, discount);
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.createSQLQuery("INSERT INTO Product (id, category, name, price, discount, actualPrice, totalVolume, data) VALUES (" + id +
                        " ,'" + category + "' ,'" + name + "' ," + price + " ," + discount + " ," + actualPrice + " ," + totalVolume + ", NOW())").executeUpdate();
//        String select = "INSERT product (id, category, name, price, discount, actualPrice, totalVolume, data) VALUES (" + id +
//                " ,'" + category + "' ,'" + name + "' ," + price + " ," + discount + " ," + actualPrice + " ," + totalVolume + ", NOW())";
//        selectBD(select);
        session.close();
    }

    // метод для расчета стоимости с учетом скидки
    public static double calculating(double price, double discount) {
        return (price - (price * discount / 100));
    }


    // формирование ID с одновременной проверкой (если есть пропуск (например 2, 3, ,5 то будет присвоен id=4))
    public int createId(List<Product> newList) {
        int id = 0; // по умолчанию id = 0
        if (!newList.isEmpty()) { // если записи имеются, проверяем на пропущенные id
            SortDataBase.sortById(newList); //сортируем для корректной проверки
            int i = 0;
            for (Product product : newList) { // проверяем
                if (product.getId() == i) i++; // теперь i больше текущего id на 1
                id = i; // присваиваем значение id (здесь id на 1 больше последнего проверенного)
            }
        }
        return id;
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }
}