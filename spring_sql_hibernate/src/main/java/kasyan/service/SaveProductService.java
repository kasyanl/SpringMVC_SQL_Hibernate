package kasyan.service;

import kasyan.bean.BuyProduct;
import kasyan.bean.Product;
import kasyan.bean.ProductOfDelete;
import kasyan.exceptions.ProductNotFoundException;
import kasyan.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaveProductService{

    private GetProductService getProductService;

    /* отправка запроса на добавление новой записи в БД Product
   и автоматическим расчетом цены с учетом скидки */
    public void saveProduct(String category, String name, double price, double discount, double totalVolume){
        List<Product> newList = getProductService.findAll();
        int id = createId(newList);
        double actualPrice = calculating(price, discount);

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Product product = new Product();

        product.setId(id);
        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setActualPrice(actualPrice);
        product.setTotalVolume(totalVolume);
        session.save(product);

        session.getTransaction().commit();

        session.close();
    }

    public void saveProductOfDelete(int id) throws ProductNotFoundException {
        ProductOfDelete productOfDelete = new ProductOfDelete();
        Product product = getProductService.findById(id);

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        productOfDelete.setId(product.getId());
        productOfDelete.setCategory(product.getCategory());
        productOfDelete.setName(product.getName());
        productOfDelete.setPrice(product.getPrice());
        productOfDelete.setDiscount(product.getDiscount());
        productOfDelete.setActualPrice(product.getActualPrice());
        productOfDelete.setTotalVolume(product.getTotalVolume());
        session.save(productOfDelete);

        session.getTransaction().commit();

        session.close();
    }

    // выбор продукта для покупки (передаем количество или вес продукта), добавляем в отдельную БД
    public void saveBayProduct(int id, double quantity) throws ProductNotFoundException {
        Product product = getProductService.findById(id);
        BuyProduct buyProduct = new BuyProduct();
        double totalPrice = product.getActualPrice() * quantity;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        buyProduct.setId(product.getId());
        buyProduct.setName(product.getName());
        buyProduct.setActualPrice(product.getActualPrice());
        buyProduct.setQuantity(quantity);
        buyProduct.setTotalPrice(totalPrice);
        session.save(buyProduct);

        session.getTransaction().commit();
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