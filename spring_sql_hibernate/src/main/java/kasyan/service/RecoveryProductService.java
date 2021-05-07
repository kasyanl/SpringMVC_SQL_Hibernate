package kasyan.service;

import kasyan.bean.Product;
import kasyan.repository.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RecoveryProductService extends RepositoryService {

    private GetProductService getProductService;
    private SaveProductService saveProductService;
    private DeleteProductService deleteProductService;

    // восстановление всех записей из корзины
    public void recoveryAllProduct() throws SQLException {
        List<Product> newList = getProductService.findAllDeleted();
        for (Product product : newList) {
            saveProductService.save(product.getCategory(), product.getName(), product.getPrice(), product.getDiscount(), product.getTotalVolume());
        }
        deleteProductService.cleanBasket();
    }

    //восстанавливаем удаленный ранее Product по его ID и отправка запроса в БД
    public void recovered(int id) throws SQLException {
        List<Product> newList = getProductService.findAllDeleted();
        String selectDel = "";
        for (Product product : newList) {
            if (product.getId() == id) {
                saveProductService.save(product.getCategory(), product.getName(), product.getPrice(), product.getDiscount(), product.getTotalVolume()); // добавление в основную БД
                selectDel = "DELETE FROM productofdelete WHERE id=" + id; // запрос на удаление из корзины
                break;
            }
        }
        selectBD(selectDel);
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