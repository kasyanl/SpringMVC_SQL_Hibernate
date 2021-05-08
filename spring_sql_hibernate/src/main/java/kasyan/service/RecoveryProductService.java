package kasyan.service;

import kasyan.bean.ProductOfDelete;
import kasyan.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryProductService{

    private GetProductService getProductService;
    private SaveProductService saveProductService;
    private DeleteProductService deleteProductService;

    // восстановление всех записей из корзины
    public void recoveryAllProduct(){
        List<ProductOfDelete> newList = getProductService.findAllDeleted();
        for (ProductOfDelete product : newList) {
            saveProductService.saveProduct(product.getCategory(), product.getName(),
                    product.getPrice(), product.getDiscount(), product.getTotalVolume());
        }
        deleteProductService.cleanBasket();
    }

    //восстанавливаем удаленный ранее Product по его ID и отправка запроса в БД
    public void recovered(int id){
        List<ProductOfDelete> newList = getProductService.findAllDeleted();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        for (ProductOfDelete product : newList) {
            if (product.getId() == id) {

                saveProductService.saveProduct(product.getCategory(), product.getName(), product.getPrice(), product.getDiscount(), product.getTotalVolume());

                // добавление в основную БД
                session.createQuery("INSERT INTO Product (id, category, name, price, discount, actualPrice, totalVolume, data)" +
                        "SELECT p.id, p.category, p.name, p.price, p.discount, p.actualPrice, p.totalVolume, p.data FROM ProductOfDelete p " +
                        "WHERE id=:id").setParameter("id", id);// VALUES (" + id +
//                        " ,'" + product.getCategory() + "', '" + product.getName() + "', " + product.getPrice() + ", " +
//                        product.getDiscount() + ", " + product.getActualPrice() + ", " + product.getTotalVolume() + ", NOW())").executeUpdate();
                session.createQuery("DELETE FROM ProductOfDelete WHERE id=:id").setParameter("id", id);
//                selectDel = "DELETE FROM productofdelete WHERE id=" + id; // запрос на удаление из корзины
                break;
            }
        }
        session.close();
//        selectBD(selectDel);
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }
    @Autowired
    public void setSaveProductService(SaveProductService saveProductService) {
        this.saveProductService = saveProductService;
    }
    @Autowired
    public void setDeleteProductService(DeleteProductService deleteProductService) {
        this.deleteProductService = deleteProductService;
    }
}