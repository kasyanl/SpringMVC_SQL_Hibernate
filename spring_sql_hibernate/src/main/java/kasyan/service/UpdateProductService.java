package kasyan.service;

import kasyan.bean.Product;
import kasyan.exceptions.ProductNotFoundException;
import kasyan.repository.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import static kasyan.service.SaveProductService.calculating;

@Service
public class UpdateProductService extends RepositoryService {

    private GetProductService getProductService;

    // отправляем запрос в БД на обновление Product по ID
    public void update(int id, String category, String name, double price, double discount, double totalVolume) throws SQLException {
        double actualPrice = calculating(price, discount);
        String select = "UPDATE product SET category='" + category + "', name='" + name + "', price=" + price +
                ", discount=" + discount + ", actualPrice=" + actualPrice + ", totalVolume=" + totalVolume + ", data=NOW() WHERE id=" + id;
        selectBD(select);
    }

    // установка скидки для одной категории
    public void updateDiscountForCategory(String category, double discount) throws SQLException {
        List<Product> listCategory = getProductService.fineCategoryForRead(category);
        for (Product product : listCategory) {
            update(product.getId(), category, product.getName(), product.getPrice(), discount, product.getTotalVolume());
        }
    }

    // выбор продукта для покупки (передаем количество или вес продукта), добавляем в отдельную БД
    public void bayProduct(int id, double quantity) throws SQLException, ProductNotFoundException {
        Product product = getProductService.findById(id);
        double totalPrice = product.getActualPrice() * quantity;

        selectBD("INSERT buyproduct (id, name, actualPrice, quantity, totalPrice) VALUES (" + product.getId() + ", '" + product.getName() +
                "', " + product.getActualPrice() + ", " + quantity + ", " + totalPrice + ")");
    }

    // сохранение данных после изменения
    public void endTransaction() throws SQLException {
        List<Product> newList = getProductService.findAllBuyProduct();
        for (Product product : newList) {
            selectBD("UPDATE product SET totalVolume=totalVolume-" + product.getQuantity() + ", data=NOW() WHERE id=" + product.getId());
        }
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }
}