package kasyan.service;

import kasyan.bean.BuyProduct;
import kasyan.bean.Product;
import kasyan.bean.ProductOfDelete;
import kasyan.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DeleteProductService{

    private GetProductService getProductService;

    //находим Product по его ID и отправка запроса в БД для удаления и одновременно добавления в "корзину" (и добавляем дату удаления)
    public void delete(int id) throws SQLException {

        List<Product> newList = getProductService.findAll();
//        String select = "";
//        String deleteProduct = "";
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        for (Product product : newList) {
            if (product.getId() == id) {
                session.createQuery("DELETE Product WHERE id= :id").setParameter("id", product.getId()).executeUpdate();
                session.createQuery("INSERT ProductOfDdelete (id, category, name, price, discount, actualPrice, totalVolume, data) VALUES (" + id +
                        " ,'" + product.getCategory() + "', '" + product.getName() + "', " + product.getPrice() + ", " +
                        product.getDiscount() + ", " + product.getActualPrice() + ", " + product.getTotalVolume() + ", NOW())").executeUpdate();
                break;
//                select = "DELETE FROM product WHERE id=" + id;
//                deleteProduct = "INSERT productofdelete (id, category, name, price, discount, actualPrice, totalVolume, data) VALUES (" + id +
//                        " ,'" + product.getCategory() + "', '" + product.getName() + "', " + product.getPrice() + ", " +
//                        product.getDiscount() + ", " + product.getActualPrice() + ", " + product.getTotalVolume() + ", NOW())";
//                break;
            }
        }
//        selectBD(select); // отправка запроса на удаление из основной БД
//        selectBD(deleteProduct); // отправка запроса на добавление в корзину
        session.close();
    }

    //находим Product по его ID с писке покупок и отправляем запрос на его даление
    public void deleteBuy(int id){
        List<BuyProduct> newList = getProductService.findAllBuyProduct();
//        String select = "";
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        for (BuyProduct product : newList) {
            if (product.getId() == id) {
                session.createQuery("DELETE BuyProduct WHERE id= :id").setParameter("id", product.getId()).executeUpdate();
//                select = "DELETE FROM buyproduct WHERE id=" + id;
                break;
            }
        }
//        selectBD(select); // отправка запроса на удаление из основной БД
        session.close();
    }

    //находим Product по его ID  в корзине и отправка запроса для удаления
    public void deleteOfBasket(int id){
        List<ProductOfDelete> newList = getProductService.findAllDeleted();
//        String select = "";
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        for (ProductOfDelete product : newList) {
            if (product.getId() == id) {
                session.createQuery("DELETE ProductOfDelete WHERE id= :id").setParameter("id", product.getId()).executeUpdate();
//                select = "DELETE FROM productofdelete WHERE id=" + id;
                break;
            }
        }
//        selectBD(select); // отправка запроса на удаление из основной БД
        session.close();
    }

    //очистка всех данных из корзины
    public void cleanBasket(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.createSQLQuery("TRUNCATE table productofdelete").executeUpdate();
//        selectBD("TRUNCATE TABLE productofdelete");
        session.close();
    }

    // очистка БД с покупками
    public void cleanBuyDB(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.createSQLQuery("TRUNCATE table buyproduct").executeUpdate();
//        selectBD("TRUNCATE TABLE buyproduct");
        session.close();
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }
}