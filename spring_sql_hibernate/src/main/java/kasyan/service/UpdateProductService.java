package kasyan.service;

import kasyan.bean.BuyProduct;
import kasyan.bean.Product;
import kasyan.exceptions.ProductNotFoundException;
import kasyan.util.HibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

import static kasyan.service.SaveProductService.calculating;

@Service
public class UpdateProductService {

    private GetProductService getProductService;

    // отправляем запрос в БД на обновление Product по ID
    public void update(int id, String category, String name, double price, double discount, double totalVolume) {
        double actualPrice = calculating(price, discount);
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("UPDATE Product SET category= :category, name=:name, price=:price," +
                " discount=:discount, actualPrice=:actualPrice, totalVolume=:totalVolume WHERE id=:id")
                .setParameter("category", category)
                .setParameter("name", name)
                .setParameter("price", price)
                .setParameter("discount", discount)
                .setParameter("actualPrice", actualPrice)
                .setParameter("totalVolume", totalVolume)
                .setParameter("id", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    // установка скидки для одной категории
    public void updateDiscountForCategory(String category, double discount) {

        List<Product> listCategory = getProductService.fineCategoryForRead(category);
        for (Product product : listCategory) {
            update(product.getId(), category, product.getName(), product.getPrice(), discount, product.getTotalVolume());
        }
    }

    // сохранение данных после изменения
    public void endTransaction() throws ProductNotFoundException {
        List<BuyProduct> newListBuy = getProductService.findAllBuyProduct();
//        List<Product> newListProduct = getProductService.findAll();

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        for (BuyProduct buyProduct : newListBuy) {
            Product product = getProductService.findById(buyProduct.getId());
            double totalVolume = product.getTotalVolume() - buyProduct.getQuantity();
            session.createQuery("UPDATE Product SET totalVolume=:totalVolume WHERE id=:id")
                    .setParameter("totalVolume", totalVolume)
                    .setParameter("id", buyProduct.getId())
                    .executeUpdate();
        }
        session.getTransaction().commit();
        session.close();
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }
}