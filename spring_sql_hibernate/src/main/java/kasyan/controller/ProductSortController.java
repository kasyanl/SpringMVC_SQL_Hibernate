package kasyan.controller;

import kasyan.service.SortProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

//Контроллер для сортировки списка продуктов

@Controller
@RequestMapping(value = "/product")
public class ProductSortController {

    private SortProductService sortProductService;

    // сортировка списка по ID (от меньшего к большему)
    @GetMapping(value = "/sortbyid")
    public ModelAndView sortById() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyid");
        modelAndView.addObject("product", sortProductService.sortList(1));
        return modelAndView;
    }

    // сортировка списка по ID (от большего к меньшему)
    @GetMapping(value = "/sortbyidreverse")
    public ModelAndView sortByIdReverse() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyidreverse");
        modelAndView.addObject("product", sortProductService.sortList(2));
        return modelAndView;
    }

    // сортировка списка по категории (от A к Z)
    @GetMapping(value = "/sortbycategory")
    public ModelAndView sortByCategory() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbycategory");
        modelAndView.addObject("product", sortProductService.sortList(3));
        return modelAndView;
    }

    // сортировка списка по категории (от Z к A)
    @GetMapping(value = "/sortbycategoryreverse")
    public ModelAndView sortByCategoryReverse() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbycategoryreverse");
        modelAndView.addObject("product", sortProductService.sortList(4));
        return modelAndView;
    }

    // сортировка списка по названию (A -> Z)
    @GetMapping(value = "/sortbyname")
    public ModelAndView sortByName() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyname");
        modelAndView.addObject("product", sortProductService.sortList(5));
        return modelAndView;
    }

    // сортировка списка по названию (Z -> A)
    @GetMapping(value = "/sortbynamereverse")
    public ModelAndView sortByNameReverse() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbynamereverse");
        modelAndView.addObject("product", sortProductService.sortList(6));
        return modelAndView;
    }

    // сортировка списка по цене (от меньшего к большему)
    @GetMapping(value = "/sortbyprice")
    public ModelAndView sortByPrice() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyprice");
        modelAndView.addObject("product", sortProductService.sortList(7));
        return modelAndView;
    }

    // сортировка списка по цене (от большего к меньшему)
    @GetMapping(value = "/sortbypricereverse")
    public ModelAndView sortByPriceReverse() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbypricereverse");
        modelAndView.addObject("product", sortProductService.sortList(8));
        return modelAndView;
    }

    // сортировка списка по скидке (от меньшего к большему)
    @GetMapping(value = "/sortbydiscount")
    public ModelAndView sortByDiscount() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbydiscount");
        modelAndView.addObject("product", sortProductService.sortList(9));
        return modelAndView;
    }

    // сортировка списка по скидке (от большего к меньшему)
    @GetMapping(value = "/sortbydiscountreverse")
    public ModelAndView sortByDiscountReverse() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbydiscountreverse");
        modelAndView.addObject("product", sortProductService.sortList(10));
        return modelAndView;
    }

    // сортировка списка по конечной цене (от меньшего к большему)
    @GetMapping(value = "/sortbyactualprice")
    public ModelAndView sortByActualPrice() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyactualprice");
        modelAndView.addObject("product", sortProductService.sortList(11));
        return modelAndView;
    }

    // сортировка списка по конечной цене (от большего к меньшему)
    @GetMapping(value = "/sortbyactualpricereverse")
    public ModelAndView sortByActualPriceReverse() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyactualpricereverse");
        modelAndView.addObject("product", sortProductService.sortList(12));
        return modelAndView;
    }

    // сортировка списка по наличию (от меньшего к большему)
    @GetMapping(value = "/sortbytotalvolume")
    public ModelAndView sortByTotalVolume() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbytotalvolume");
        modelAndView.addObject("product", sortProductService.sortList(13));
        return modelAndView;
    }

    // сортировка списка по наличию (от большего к меньшему)
    @GetMapping(value = "/sortbytotalvolumereverse")
    public ModelAndView sortByTotalVolumeReverse() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbytotalvolumereverse");
        modelAndView.addObject("product", sortProductService.sortList(14));
        return modelAndView;
    }

    // сортировка списка по ID (от меньшего к большему) для Гостя
    @GetMapping(value = "/sortbyidguest")
    public ModelAndView sortByIdGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbyidguest");
        modelAndView.addObject("product", sortProductService.sortList(1));
        return modelAndView;
    }

    // сортировка списка по ID (от большего к меньшему) для Гостя
    @GetMapping(value = "/sortbyidreverseguest")
    public ModelAndView sortByIdReverseGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbyidreverseguest");
        modelAndView.addObject("product", sortProductService.sortList(2));
        return modelAndView;
    }

    // сортировка списка по категории (от A к Z) для Гостя
    @GetMapping(value = "/sortbycategoryguest")
    public ModelAndView sortByCategoryGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbycategoryguest");
        modelAndView.addObject("product", sortProductService.sortList(3));
        return modelAndView;
    }

    // сортировка списка по категории (от Z к A) для Гостя
    @GetMapping(value = "/sortbycategoryreverseguest")
    public ModelAndView sortByCategoryReverseGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbycategoryreverseguest");
        modelAndView.addObject("product", sortProductService.sortList(4));
        return modelAndView;
    }

    // сортировка списка по названию (A -> Z) для Гостя
    @GetMapping(value = "/sortbynameguest")
    public ModelAndView sortByNameGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbynameguest");
        modelAndView.addObject("product", sortProductService.sortList(5));
        return modelAndView;
    }

    // сортировка списка по названию (Z -> A) для Гостя
    @GetMapping(value = "/sortbynamereverseguest")
    public ModelAndView sortByNameReverseGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbynamereverseguest");
        modelAndView.addObject("product", sortProductService.sortList(6));
        return modelAndView;
    }

    // сортировка списка по цене (от меньшего к большему) для Гостя
    @GetMapping(value = "/sortbypriceguest")
    public ModelAndView sortByPriceGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbypriceguest");
        modelAndView.addObject("product", sortProductService.sortList(7));
        return modelAndView;
    }

    // сортировка списка по цене (от большего к меньшему) для Гостя
    @GetMapping(value = "/sortbypricereverseguest")
    public ModelAndView sortByPriceReverseGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbypricereverseguest");
        modelAndView.addObject("product", sortProductService.sortList(8));
        return modelAndView;
    }

    // сортировка списка по скидке (от меньшего к большему) для Гостя
    @GetMapping(value = "/sortbydiscountguest")
    public ModelAndView sortByDiscountGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbydiscountguest");
        modelAndView.addObject("product", sortProductService.sortList(9));
        return modelAndView;
    }

    // сортировка списка по скидке (от большего к меньшему) для Гостя
    @GetMapping(value = "/sortbydiscountreverseguest")
    public ModelAndView sortByDiscountReverseGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbydiscountreverseguest");
        modelAndView.addObject("product", sortProductService.sortList(10));
        return modelAndView;
    }

    // сортировка списка по конечной цене (от меньшего к большему) для Гостя
    @GetMapping(value = "/sortbyactualpriceguest")
    public ModelAndView sortByActualPriceGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbyactualpriceguest");
        modelAndView.addObject("product", sortProductService.sortList(11));
        return modelAndView;
    }

    // сортировка списка по конечной цене (от большего к меньшему) для Гостя
    @GetMapping(value = "/sortbyactualpricereverseguest")
    public ModelAndView sortByActualPriceReverseGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbyactualpricereverseguest");
        modelAndView.addObject("product", sortProductService.sortList(12));
        return modelAndView;
    }

    // сортировка списка по наличию (от меньшего к большему)
    @GetMapping(value = "/sortbytotalvolumeguest")
    public ModelAndView sortByTotalVolumeGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbytotalvolumeguest");
        modelAndView.addObject("product", sortProductService.sortList(13));
        return modelAndView;
    }

    // сортировка списка по наличию (от большего к меньшему)
    @GetMapping(value = "/sortbytotalvolumereverseguest")
    public ModelAndView sortByTotalVolumeReverseGuest() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbytotalvolumereverseguest");
        modelAndView.addObject("product", sortProductService.sortList(14));
        return modelAndView;
    }

    @Autowired
    public void setSortProductService(SortProductService sortProductService) {
        this.sortProductService = sortProductService;
    }
}