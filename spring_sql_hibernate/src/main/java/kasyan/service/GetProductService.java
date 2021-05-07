package kasyan.service;

import kasyan.bean.BuyProduct;
import kasyan.bean.Product;
import kasyan.bean.ProductOfDelete;
import kasyan.exceptions.ProductNotFoundException;
import kasyan.repository.RepositoryService;
import kasyan.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetProductService extends RepositoryService {

    //отправка запроса на получение всех продуктов из основной БД
    public List<Product> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product").getResultList();
        session.close();
        return product;
    }

    //отправка запроса на получение всех ранее удаленных продуктов из основной БД
    public List<ProductOfDelete> findAllDeleted(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<ProductOfDelete> product = session.createQuery("FROM ProductOfDelete").getResultList();
        session.close();
        return product;
//        String select = "SELECT id, category, name, price, discount, ROUND (actualPrice, 2) AS actualPrice, ROUND (totalVolume, 3) AS totalVolume, data FROM productofdelete";
//        return findProductFromBD(select);
    }

    //отправка запроса на получение всех ранее удаленных продуктов из основной БД
    public List<BuyProduct> findAllBuyProduct() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<BuyProduct> product = session.createQuery("FROM BuyProduct ").getResultList();
        session.close();
        return product;
//        String select = "SELECT id, name, ROUND (actualPrice, 2) AS actualPrice, quantity, ROUND (totalPrice, 2) AS totalPrice FROM buyproduct";
//        return findBuyProductFromBD(select);
    }

    //находим конкретный Product по ID
    public Product findById(int id) throws ProductNotFoundException{
        List<Product> newList = findAll();
        for (Product product : newList) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new ProductNotFoundException("Product with id=" + id + " not found!");
    }

    // ищем все Products одной категории и отправляем в БД соответствующий запрос
    public List<Product> fineCategoryForRead(String category) throws SQLException {
        List<Product> listProduct = findAll();
        List<Product> newListForRead = new ArrayList<>();
        for (Product product : listProduct) {
            if (product.getCategory().equals(category)) {
                newListForRead.add(product);
            }
        }
        String select = "SELECT id, category, name, price, discount, actualPrice, totalVolume, data  FROM product WHERE category='" + category + "'";
        findProductFromBD(select);
        return newListForRead;
    }

    // расчет общей суммы покупок
    public double totalPrise() throws SQLException {
        List<Product> newList = findAllBuyProduct();
        double count = 0;
        for (Product product : newList) {
            count += product.getTotalPrice();
        }
        return count;
    }

    // проверка, чтобы не ввести больше количество,
    public boolean checkingForNumber(double quantity, double totalVolume) {
        return quantity <= totalVolume;
    }

    // проверка, пуста ли корзина
    public boolean basketIsEmpty() throws SQLException {
        List<Product> newList = findAllDeleted();
        return newList.isEmpty();
    }
}