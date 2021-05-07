package kasyan.controller;

import kasyan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

    private PersonService personService;

    // получение начальной страницы с формой Логин и пароль
    @GetMapping(value = "/startlogin")
    public String startLogin() {
        return "index";
    }

    // отправка логина и пароля для проверки
    @PostMapping(value = "/startlogin")
    public ModelAndView startLoginPost(@RequestParam(value = "login") String login,
                                       @RequestParam(value = "password") String password) throws SQLException {
        // разделение пользователей на юзера и гостя
        if (personService.verificationOfAuthenticity(login, password)) {
            // перенаправление на ветку юзера (логин и пароль совпали)
            return new ModelAndView("redirect:currentlogin");
        }
        // перенаправление на страницу с формой для повторного логирования (логин и/или пароль не совпали)
        return new ModelAndView("redirect:nocurrentlogin");
    }

    // получение страницы с сообщением, что вход выполнен
    @GetMapping(value = "/currentlogin")
    public String currentlogin() {
        return "currentlogin";
    }

    // получение страницы с формой для ввода логина и пароля
    @GetMapping(value = "/nocurrentlogin")
    public String nocurrentlogin() {
        return "nocurrentlogin";
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}