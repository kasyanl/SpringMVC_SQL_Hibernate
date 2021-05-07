package kasyan.controller;

import kasyan.service.ExportToExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/product")
public class ExportToExcelController {

    private ExportToExcelService exportToExcelService;

    // получение списка категории ALCOHOLIC_BEVERAGES
    @GetMapping(value = "/exportexcel/alcohol")
    public ModelAndView exportExcelAlcohol() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/alcohol");
        modelAndView.addObject("product", exportToExcelService.exportCategoryList("ALCOHOLIC_BEVERAGES"));
        return modelAndView;
    }

    // экспорт списка категории BERRIES в excel
    @GetMapping(value = "/exportexcel/berries")
    public ModelAndView exportExcelBerries() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/berries");
        modelAndView.addObject("product", exportToExcelService.exportCategoryList("BERRIES"));
        return modelAndView;
    }

    // экспорт списка категории FRUITS в excel
    @GetMapping(value = "/exportexcel/fruits")
    public ModelAndView exportExcelFruits() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/fruits");
        modelAndView.addObject("product", exportToExcelService.exportCategoryList("FRUITS"));
        return modelAndView;
    }

    // экспорт списка категории MEAT в excel
    @GetMapping(value = "/exportexcel/meat")
    public ModelAndView exportExcelMeat() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/meat");
        modelAndView.addObject("product", exportToExcelService.exportCategoryList("MEAT"));
        return modelAndView;
    }

    // экспорт списка категории MILK_PRODUCT в excel
    @GetMapping(value = "/exportexcel/milk")
    public ModelAndView exportExcelMikl() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/milk");
        modelAndView.addObject("product", exportToExcelService.exportCategoryList("MILK_PRODUCT"));
        return modelAndView;
    }

    // экспорт списка категории VEGETABLES в excel
    @GetMapping(value = "/exportexcel/vegetables")
    public ModelAndView exportExcelVegetables() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/exportexcel/vegetables");
        modelAndView.addObject("product", exportToExcelService.exportCategoryList("VEGETABLES"));
        return modelAndView;
    }

    // получение списка категории ALCOHOLIC_BEVERAGES для Гостя
    @GetMapping(value = "/exportexcel/alcoholguest")
    public ModelAndView exportExcelAlcoholGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/exportexcel/alcoholguest");
        modelAndView.addObject("product", exportToExcelService.exportCategoryList("ALCOHOLIC_BEVERAGES"));
        return modelAndView;
    }

    // экспорт списка категории BERRIES в excel для Гостя
    @GetMapping(value = "/exportexcel/berriesguest")
    public ModelAndView exportExcelBerriesGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/exportexcel/berriesguest");
        modelAndView.addObject("product", exportToExcelService.exportCategoryList("BERRIES"));
        return modelAndView;
    }

    // экспорт списка категории FRUITS в excel для Гостя
    @GetMapping(value = "/exportexcel/fruitsguest")
    public ModelAndView exportExcelFruitsGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/exportexcel/fruitsguest");
        modelAndView.addObject("product", exportToExcelService.exportCategoryList("FRUITS"));
        return modelAndView;
    }

    // экспорт списка категории MEAT в excel для Гостя
    @GetMapping(value = "/exportexcel/meatguest")
    public ModelAndView exportExcelMeatGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/exportexcel/meatguest");
        modelAndView.addObject("product", exportToExcelService.exportCategoryList("MEAT"));
        return modelAndView;
    }

    // экспорт списка категории MILK_PRODUCT в excel для Гостя
    @GetMapping(value = "/exportexcel/milkguest")
    public ModelAndView exportExcelMiklGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/exportexcel/milkguest");
        modelAndView.addObject("product", exportToExcelService.exportCategoryList("MILK_PRODUCT"));
        return modelAndView;
    }

    // экспорт списка категории VEGETABLES в excel для Гостя
    @GetMapping(value = "/exportexcel/vegetablesguest")
    public ModelAndView exportExcelVegetablesGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/exportexcel/vegetablesguest");
        modelAndView.addObject("product", exportToExcelService.exportCategoryList("VEGETABLES"));
        return modelAndView;
    }

    @Autowired
    public void setExportToExcel(ExportToExcelService exportToExcelService) {
        this.exportToExcelService = exportToExcelService;
    }
}