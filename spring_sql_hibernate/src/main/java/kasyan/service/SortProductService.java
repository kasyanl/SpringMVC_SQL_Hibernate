package kasyan.service;

import kasyan.bean.Product;
import kasyan.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortProductService extends GetProductService {

    public List<Product> sortById() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.id")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByIdReverse() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.id DESC")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByCategory() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.category")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByCategoryReverse() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.category DESC")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByName() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.name")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByNameReverse() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.name DESC")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByPrice() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.price")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByPriceReverse() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.price DESC")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByDiscount() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.discount")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByDiscountReverse() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.discount DESC")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByActualPrice() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.actualPrice")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByActualPriceReverse() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.actualPrice DESC")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByTotalVolume() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.totalVolume")
                .getResultList();
        session.close();
        return product;
    }

    public List<Product> sortByTotalVolumeReverse() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Product> product = session.createQuery("FROM Product P ORDER BY P.totalVolume DESC")
                .getResultList();
        session.close();
        return product;
    }
}
