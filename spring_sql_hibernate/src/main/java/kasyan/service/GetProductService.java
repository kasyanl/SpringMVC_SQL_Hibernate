package kasyan.service;

import kasyan.bean.BuyProduct;
import kasyan.bean.Product;
import kasyan.bean.ProductOfDelete;
import kasyan.exceptions.ProductNotFoundException;
import kasyan.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductService {

    //отправка запроса на получение всех продуктов из основной БД
    public List<Product> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product").getResultList();
        session.close();
        return product;
    }

    //отправка запроса на получение всех ранее удаленных продуктов из основной БД
    public List<ProductOfDelete> findAllDeleted() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<ProductOfDelete> product = session.createQuery("FROM ProductOfDelete").getResultList();
        session.close();
        return product;
    }

    //отправка запроса на получение всех ранее удаленных продуктов из основной БД
    public List<BuyProduct> findAllBuyProduct() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<BuyProduct> product = session.createQuery("FROM BuyProduct").getResultList();
        session.close();
        return product;
    }

    //находим конкретный Product по ID
    public Product findById(int id) throws ProductNotFoundException {
        List<Product> newList = findAll();
        for (Product product : newList) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new ProductNotFoundException("Product with id=" + id + " not found!");
    }

    // ищем все Products одной категории и отправляем в БД соответствующий запрос
    public List<Product> fineCategoryForRead(String category) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product WHERE category= :category")
                .setParameter("category", category)
                .getResultList();
        session.close();
        return product;
    }

    // расчет общей суммы покупок
    public double totalPrise() {
        List<BuyProduct> newList = findAllBuyProduct();
        double count = 0;
        for (BuyProduct product : newList) {
            count += product.getTotalPrice();
        }
        return count;
    }

    // проверка, чтобы не ввести больше количество,
    public boolean checkingForNumber(double quantity, double totalVolume) {
        return quantity <= totalVolume;
    }

    // проверка, пуста ли корзина
    public boolean basketIsEmpty() {
        List<ProductOfDelete> newList = findAllDeleted();
        return newList.isEmpty();
    }
}