package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import security.dao.security.RoleDAO;
import security.service.PassengerService;

import java.util.Map;

@Controller
public class AppController {

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    PassengerService passengerService;

    @RequestMapping(value = "/admin")
    public ModelAndView admin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String welcomeMessage = "Добро пожаловать, " + authentication.getName() + "!";
        return new ModelAndView("admin", "welcomeMessage", welcomeMessage);
    }

    @RequestMapping(value = "/passenger")
    public ModelAndView user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String welcomeMessage = "Добро пожаловать, " + passengerService.findByUsername(authentication.getName()).getFirstName() + "!";
        return new ModelAndView("passenger", "welcomeMessage", welcomeMessage);
    }

    @RequestMapping(value = "/error")
    public String error(ModelMap model) {
        model.addAttribute("error", "true");
        return "loginPage";
    }

    @RequestMapping(value = "/logout")
    public String logout(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.setAuthenticated(false);
        model.addAttribute("logout", "true");
        return "loginPage";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(Model model, @RequestParam Map<String, String> paramMap) {
        if(!paramMap.get("password").equals(paramMap.get("passwordConfirm"))){
            model.addAttribute("message", "Пароли не совпали!");
            return "registration";
        }
        if(passengerService.findByUsername(paramMap.get("username"))!=null){
            model.addAttribute("message", "Пользователь с таким именм уже зарегистрирован!");
            return "registration";
        }
        passengerService.passengerRegistration(paramMap);
        return "loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "loginPage";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.POST)
    public String loginPage() {
        return "loginPage";
    }

    @RequestMapping("/registration")
    public String registration() {
        return "registration";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }
}