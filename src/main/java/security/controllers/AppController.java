package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import security.dao.security.RoleDAO;
import security.service.PassengerService;

import java.util.Map;

@Controller
public class AppController {

    private static final String LOGIN_PAGE = "loginPage";
    private static final String REGISTRATION = "registration";
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    PassengerService passengerService;

    @GetMapping(value = "/admin")
    public ModelAndView admin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String welcomeMessage = "Добро пожаловать, " + authentication.getName() + "!";
        return new ModelAndView("admin", "welcomeMessage", welcomeMessage);
    }


    @GetMapping(value = "/error")
    public String error(ModelMap model) {
        model.addAttribute("error", "true");
        return LOGIN_PAGE;
    }

    @GetMapping(value = "/logout")
    public String logout(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.setAuthenticated(false);
        model.addAttribute("logout", "true");
        return LOGIN_PAGE;
    }

    @PostMapping(value = "/registration")
    public String registration(Model model, @RequestParam Map<String, String> paramMap) {
        if(!paramMap.get("password").equals(paramMap.get("passwordConfirm"))){
            model.addAttribute("message", "Пароли не совпали!");
            return REGISTRATION;
        }
        if(passengerService.findByUsername(paramMap.get("username"))!=null){
            model.addAttribute("message", "Пользователь с таким именм уже зарегистрирован!");
            return REGISTRATION;
        }
        passengerService.passengerRegistration(paramMap);
        return LOGIN_PAGE;
    }

    @GetMapping(value = "/login")
    public String login() {
        return LOGIN_PAGE;
    }

    @PostMapping(value = "/loginPage")
    public String loginPage() {
        return LOGIN_PAGE;
    }

    @GetMapping("/registration")
    public String registration() {
        return REGISTRATION;
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }
}