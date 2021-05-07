package kasyan.controller;

import kasyan.exceptions.ProductNotFoundException;
import kasyan.service.DeleteProductService;
import kasyan.service.ExportToExcelService;
import kasyan.service.GetProductService;
import kasyan.service.UpdateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/product")
public class BuyController {

    private DeleteProductService deleteProductService;
    private ExportToExcelService exportToExcelService;
    private GetProductService getProductService;
    private UpdateProductService updateProductService;

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/buystarted")
    public ModelAndView buyStarted() throws SQLException {
        deleteProductService.cleanBuyDB();
        return new ModelAndView("adminpages/buystarted");

    }

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/buyproduct")
    public ModelAndView buyProductGet() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/buyproduct");
        modelAndView.addObject("product", getProductService.findAll());
        return modelAndView;
    }

    // отправка данных для добавления продуктов в БД и перенаправления на страницу со всем списком
    @PostMapping(value = "/buyproduct")
    public ModelAndView buyProductPost(@RequestParam(value = "id") int id,
                                       @RequestParam(value = "quantity") double quantity,
                                       @RequestParam(value = "totalVolume") double totalVolume) throws SQLException, ProductNotFoundException {
        if (getProductService.checkingForNumber(quantity, totalVolume)) {
            updateProductService.bayProduct(id, quantity);
            return new ModelAndView("redirect:/product/buyproduct");
        }
        return new ModelAndView("redirect:/product/buyproduct");
    }

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/endbuyproduct")
    public ModelAndView endBuyProductGet() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/endbuyproduct");
        modelAndView.addObject("product", getProductService.findAllBuyProduct());
        return modelAndView;
    }

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/checkend")
    public ModelAndView checkend() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/checkend");
        exportToExcelService.check(getProductService.findAllBuyProduct());
        updateProductService.endTransaction();
        modelAndView.addObject("product", getProductService.findAllBuyProduct());
        return modelAndView;
    }

    // получение страницы с сообщением, что продукт удален из основной БД
    @GetMapping(value = "/deleteproductbuy")
    public ModelAndView deleteproduct(@RequestParam(value = "id") int id) throws SQLException {
        deleteProductService.deleteBuy(id);
        return new ModelAndView("redirect:/product/endbuyproduct");
    }

    // получение страницы с сообщением, что продукт удален из основной БД
    @GetMapping(value = "/failbuyproduct")
    public ModelAndView failbuyproduct() throws SQLException {
        deleteProductService.cleanBuyDB();
        return new ModelAndView("adminpages/failbuyproduct");
    }

    @Autowired
    public void setExportToExcel(ExportToExcelService exportToExcelService) {
        this.exportToExcelService = exportToExcelService;
    }

    @Autowired
    public void setDeleteProductService(DeleteProductService deleteProductService) {
        this.deleteProductService = deleteProductService;
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @Autowired
    public void setUpdateProductService(UpdateProductService updateProductService) {
        this.updateProductService = updateProductService;
    }
}