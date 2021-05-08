package kasyan.service;

import kasyan.bean.BuyProduct;
import kasyan.bean.ProductOfDelete;
import kasyan.exceptions.ProductNotFoundException;
import kasyan.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteProductService {

    private GetProductService getProductService;
    private SaveProductService saveProductService;

    //находим Product по его ID и отправка запроса в БД для удаления и одновременно добавления в "корзину" (и добавляем дату удаления)
    public void deleteProduct(int id) throws ProductNotFoundException {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        saveProductService.saveProductOfDelete(id);
        session.beginTransaction();
        session.createQuery("DELETE Product WHERE id= :id").setParameter("id", id).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    //находим Product по его ID с писке покупок и отправляем запрос на его даление
    public void deleteBuy(int id) {
        List<BuyProduct> newList = getProductService.findAllBuyProduct();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        for (BuyProduct product : newList) {
            if (product.getId() == id) {
                session.createQuery("DELETE BuyProduct WHERE id= :id")
                        .setParameter("id", product.getId()).executeUpdate();
                break;
            }
        }
        session.close();
    }

    //находим Product по его ID  в корзине и отправка запроса для удаления
    public void deleteOfBasket(int id) {
        List<ProductOfDelete> newList = getProductService.findAllDeleted();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        for (ProductOfDelete product : newList) {
            if (product.getId() == id) {
                session.createQuery("DELETE ProductOfDelete WHERE id= :id")
                        .setParameter("id", product.getId()).executeUpdate();
                break;
            }
        }
        session.close();
    }

    //очистка всех данных из корзины
    public void cleanBasket() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM ProductOfDelete").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    // очистка БД с покупками
    public void cleanBuyDB() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM BuyProduct").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @Autowired
    public void setSaveProductService(SaveProductService saveProductService) {
        this.saveProductService = saveProductService;
    }
}