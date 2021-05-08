package kasyan.service;

import kasyan.bean.BuyProduct;
import kasyan.bean.Product;
import kasyan.exceptions.ProductNotFoundException;
import kasyan.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import static kasyan.service.SaveProductService.calculating;

@Service
public class UpdateProductService{

    private GetProductService getProductService;

    // отправляем запрос в БД на обновление Product по ID
    public void update(int id, String category, String name, double price, double discount, double totalVolume) throws SQLException {
        double actualPrice = calculating(price, discount);
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.createSQLQuery("UPDATE product SET category='" + category + "', name='" + name + "', price=" + price +
                        ", discount=" + discount + ", actualPrice=" + actualPrice + ", totalVolume=" + totalVolume + ", data=NOW() WHERE id=" + id).executeUpdate();
//        String select = "UPDATE product SET category='" + category + "', name='" + name + "', price=" + price +
//                ", discount=" + discount + ", actualPrice=" + actualPrice + ", totalVolume=" + totalVolume + ", data=NOW() WHERE id=" + id;
//        selectBD(select);
        session.close();
    }

    // установка скидки для одной категории
    public void updateDiscountForCategory(String category, double discount) throws SQLException {
        List<Product> listCategory = getProductService.fineCategoryForRead(category);
        for (Product product : listCategory) {
            update(product.getId(), category, product.getName(), product.getPrice(), discount, product.getTotalVolume());
        }
    }

    // выбор продукта для покупки (передаем количество или вес продукта), добавляем в отдельную БД
    public void bayProduct(int id, double quantity) throws ProductNotFoundException {
        Product product = getProductService.findById(id);
        double totalPrice = product.getActualPrice() * quantity;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.createSQLQuery("INSERT buyproduct (id, name, actualPrice, quantity, totalPrice) VALUES (" + product.getId() + ", '" + product.getName() +
                "', " + product.getActualPrice() + ", " + quantity + ", " + totalPrice + ")");
//        selectBD("INSERT buyproduct (id, name, actualPrice, quantity, totalPrice) VALUES (" + product.getId() + ", '" + product.getName() +
//                "', " + product.getActualPrice() + ", " + quantity + ", " + totalPrice + ")");
        session.close();
    }

    // сохранение данных после изменения
    public void endTransaction() throws SQLException {
        List<BuyProduct> newList = getProductService.findAllBuyProduct();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        for (BuyProduct product : newList) {
            session.createSQLQuery("UPDATE product SET totalVolume=totalVolume-" + product.getQuantity() + ", data=NOW() WHERE id=" + product.getId());
//            selectBD("UPDATE product SET totalVolume=totalVolume-" + product.getQuantity() + ", data=NOW() WHERE id=" + product.getId());
        }
        session.close();
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }
}