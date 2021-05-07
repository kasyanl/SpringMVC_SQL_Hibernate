package kasyan.service;

import kasyan.bean.Product;
import kasyan.repository.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DeleteProductService extends RepositoryService {

    private GetProductService getProductService;

    //находим Product по его ID и отправка запроса в БД для удаления и одновременно добавления в "корзину" (и добавляем дату удаления)
    public void delete(int id) throws SQLException {

        List<Product> newList = getProductService.findAll();
        String select = "";
        String deleteProduct = "";
        for (Product product : newList) {
            if (product.getId() == id) {
                select = "DELETE FROM product WHERE id=" + id;
                deleteProduct = "INSERT productofdelete (id, category, name, price, discount, actualPrice, totalVolume, data) VALUES (" + id +
                        " ,'" + product.getCategory() + "', '" + product.getName() + "', " + product.getPrice() + ", " +
                        product.getDiscount() + ", " + product.getActualPrice() + ", " + product.getTotalVolume() + ", NOW())";
                break;
            }
        }
        selectBD(select); // отправка запроса на удаление из основной БД
        selectBD(deleteProduct); // отправка запроса на добавление в корзину
    }

    //находим Product по его ID с писке покупок и отправляем запрос на его даление
    public void deleteBuy(int id) throws SQLException {
        List<Product> newList = getProductService.findAllBuyProduct();
        String select = "";
        for (Product product : newList) {
            if (product.getId() == id) {
                select = "DELETE FROM buyproduct WHERE id=" + id;
                break;
            }
        }
        selectBD(select); // отправка запроса на удаление из основной БД
    }

    //находим Product по его ID  в корзине и отправка запроса для удаления
    public void deleteOfBasket(int id) throws SQLException {
        List<Product> newList = getProductService.findAllDeleted();
        String select = "";
        for (Product product : newList) {
            if (product.getId() == id) {
                select = "DELETE FROM productofdelete WHERE id=" + id;
                break;
            }
        }
        selectBD(select); // отправка запроса на удаление из основной БД
    }

    //очистка всех данных из корзины
    public void cleanBasket() throws SQLException {
        selectBD("TRUNCATE TABLE productofdelete");
    }

    // очистка БД с покупками
    public void cleanBuyDB() throws SQLException {
        selectBD("TRUNCATE TABLE buyproduct");
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }
}