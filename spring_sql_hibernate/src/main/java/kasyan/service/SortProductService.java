package kasyan.service;

import kasyan.bean.Product;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SortProductService  extends GetProductService{

    // сортировка списка Products по категориям, в т.ч. и реверсивно
    public List<Product> sortList(int sort) throws SQLException {
        List<Product> listProduct = findAll();
        switch (sort) {
            case 1:
                SortDataBase.sortById(listProduct);
                break;
            case 2:
                SortDataBase.sortByIdReverse(listProduct);
                break;
            case 3:
                SortDataBase.sortByCategory(listProduct);
                break;
            case 4:
                SortDataBase.sortByCategoryReverse(listProduct);
                break;
            case 5:
                SortDataBase.sortByName(listProduct);
                break;
            case 6:
                SortDataBase.sortByNameReverse(listProduct);
                break;
            case 7:
                SortDataBase.sortByPrice(listProduct);
                break;
            case 8:
                SortDataBase.sortByPriceReverse(listProduct);
                break;
            case 9:
                SortDataBase.sortByDiscount(listProduct);
                break;
            case 10:
                SortDataBase.sortByDiscountReverse(listProduct);
                break;
            case 11:
                SortDataBase.sortByActualPrice(listProduct);
                break;
            case 12:
                SortDataBase.sortByActualPriceReverse(listProduct);
                break;
            case 13:
                SortDataBase.sortByTotalVolume(listProduct);
                break;
            case 14:
                SortDataBase.sortByTotalVolumeReverse(listProduct);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sort);
        }
        return listProduct;
    }
}
