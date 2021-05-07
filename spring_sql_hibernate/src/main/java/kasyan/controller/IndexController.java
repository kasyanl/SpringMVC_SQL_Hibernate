package kasyan.controller;

import kasyan.service.ExportToExcelService;
import kasyan.service.GetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    private GetProductService getProductService;

    //получение стартовой страницы
    @GetMapping
    public String index() {
        return "index";
    }

    // получение начальной страницы для юзера
    @GetMapping(value = "/content")
    public String content() {
        return "adminpages/content";
    }

    // получение начальной страницы для гостя
    @GetMapping(value = "/contentguest")
    public String contentguest() {
        return "guestpages/contentguest";
    }

    // получения списка категории, для последующего выбора продуктов данной категории для юзера
    @GetMapping(value = "/selectcategorybyread")
    public String selectCategoryByRead() {
        return "adminpages/selectcategorybyread";
    }

    // получения списка категории, для последующего выбора продуктов данной категории для гостя
    @GetMapping(value = "/selectcategorybyreadguest")
    public String selectCategoryByReadGuest() {
        return "guestpages/selectcategorybyreadguest";
    }

    // экспорт данных из корзины в excel
    @GetMapping(value = "/exportexceldel")
    public ModelAndView exportExcelDel() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexceldel");
        modelAndView.addObject("product", ExportToExcelService.exportAllList(getProductService.findAllDeleted()));
        return modelAndView;
    }

    // экспорт данных  в excel основной БД для юзера
    @GetMapping(value = "/exportexcel")
    public ModelAndView exportExcel() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel");
        modelAndView.addObject("product", ExportToExcelService.exportAllList(getProductService.findAll()));
        return modelAndView;
    }

    // экспорт данных  в excel основной БД для гостя
    @GetMapping(value = "/exportexcelguest")
    public ModelAndView exportExcelGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/exportexcelguest");
        modelAndView.addObject("product", ExportToExcelService.exportAllList(getProductService.findAll()));
        return modelAndView;
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }
}