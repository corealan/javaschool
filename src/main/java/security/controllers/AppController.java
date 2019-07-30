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
import security.dao.security.UserDAO;
import security.model.security.Role;
import security.model.security.User;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class AppController {

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    UserDAO userDAO;

    @RequestMapping("/admin")
    public ModelAndView admin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String welcomeMessage = "Готов ударно потрудиться, " + authentication.getName() + "?";
        return new ModelAndView("admin", "welcomeMessage", welcomeMessage);
    }

    @RequestMapping("/user")
    public ModelAndView user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String welcomeMessage = "Добро пожаловать, " + authentication.getName() + "!";
        return new ModelAndView("user", "welcomeMessage", welcomeMessage);
    }

    @RequestMapping("/error")
    public String error(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.setAuthenticated(false);
        model.addAttribute("logout", "true");
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(Model model, @RequestParam Map<String, String> paramMap) {
        if(!paramMap.get("password").equals(paramMap.get("passwordConfirm"))){
            model.addAttribute("message", "Пароли не совпали!");
            return "registration";
        }
        if(userDAO.findByUsername(paramMap.get("username"))!=null){
            model.addAttribute("message", "Пользователь с таким именм уже зарегистрирован!");
            return "registration";
        }
        User user = new User();
        user.setUsername(paramMap.get("username"));
        user.setPassword(encoder.encode(paramMap.get("password")));
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleDAO.getRoleById(2L));
        user.setRoles(roles);
        userDAO.saveUser(user);
        return "login";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
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