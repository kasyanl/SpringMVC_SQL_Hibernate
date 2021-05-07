package kasyan.controller;

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
public class EditDiscountForCategoryController {

    private UpdateProductService updateProductService;

    // получение страницы с формой для изменения скидки для категории ALCOHOLIC_BEVERAGES
    @GetMapping(value = "/alcoholdiscount")
    public String alcoholDiscountPage() {
        return "adminpages/insertdiscountcategory/alcoholdiscount";
    }

    // отправка заданной скидки для категории ALCOHOLIC_BEVERAGES
    @PostMapping(value = "/alcoholdiscount")
    public ModelAndView editAlcoholDiscount(@RequestParam(value = "discount") double discount) throws SQLException {
        updateProductService.updateDiscountForCategory("ALCOHOLIC_BEVERAGES", discount);
        return new ModelAndView("redirect:/product/finealcohol");
    }

    // получение страницы с формой для изменения скидки для категории FRUITS
    @GetMapping(value = "/fruitsdiscount")
    public String fruitsDiscountPage() {
        return "adminpages/insertdiscountcategory/fruitsdiscount";
    }

    // отправка заданной скидки для категории FRUITS
    @PostMapping(value = "/fruitsdiscount")
    public ModelAndView editFruitsDiscount(@RequestParam(value = "discount") double discount) throws SQLException {
        updateProductService.updateDiscountForCategory("FRUITS", discount);
        return new ModelAndView("redirect:/product/finefruits");
    }

    // получение страницы с формой для изменения скидки для категории BERRIES
    @GetMapping(value = "/berriesdiscount")
    public String berriesDiscountPage() {
        return "adminpages/insertdiscountcategory/berriesdiscount";
    }

    // отправка заданной скидки для категории BERRIES
    @PostMapping(value = "/berriesdiscount")
    public ModelAndView editBerriesDiscount(@RequestParam(value = "discount") double discount) throws SQLException {
        updateProductService.updateDiscountForCategory("BERRIES", discount);
        return new ModelAndView("redirect:/product/fineberries");
    }

    // получение страницы с формой для изменения скидки для категории VEGETABLES
    @GetMapping(value = "/vegetablesdiscount")
    public String vegetablesDiscountPage() {
        return "adminpages/insertdiscountcategory/vegetablesdiscount";
    }

    // отправка заданной скидки для категории VEGETABLES
    @PostMapping(value = "/vegetablesdiscount")
    public ModelAndView editVegetablesDiscount(@RequestParam(value = "discount") double discount) throws SQLException {
        updateProductService.updateDiscountForCategory("VEGETABLES", discount);
        return new ModelAndView("redirect:/product/finevegetables");
    }

    // получение страницы с формой для изменения скидки для категории MILK_PRODUCT
    @GetMapping(value = "/milkproductdiscount")
    public String milkProductDiscountPage() {
        return "adminpages/insertdiscountcategory/milkproductdiscount";
    }

    // отправка заданной скидки для категории MILK_PRODUCT
    @PostMapping(value = "/milkproductdiscount")
    public ModelAndView editMilkProductDiscount(@RequestParam(value = "discount") double discount) throws SQLException {
        updateProductService.updateDiscountForCategory("MILK_PRODUCT", discount);
        return new ModelAndView("redirect:/product/finemilkproduct");
    }

    // получение страницы с формой для изменения скидки для категории MEAT
    @GetMapping(value = "/meatdiscount")
    public String meatDiscountPage() {
        return "adminpages/insertdiscountcategory/meatdiscount";
    }

    // отправка заданной скидки для категории MEAT
    @PostMapping(value = "/meatdiscount")
    public ModelAndView editMeatDiscount(@RequestParam(value = "discount") double discount) throws SQLException {
        updateProductService.updateDiscountForCategory("MEAT", discount);
        return new ModelAndView("redirect:/product/finemeat");
    }

    @Autowired
    public void setUpdateProductService(UpdateProductService updateProductService) {
        this.updateProductService = updateProductService;
    }
}