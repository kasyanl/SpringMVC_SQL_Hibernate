package kasyan;

import kasyan.bean.Product;
import kasyan.service.GetProductService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        GetProductService getProductService = new GetProductService();
        List<Product> products = getProductService.findAllDeleted();
        for(Product product : products){
            System.out.println(product);
        }
    }
}