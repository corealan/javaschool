package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import security.service.TrainService;

import java.util.Map;

@Controller
@RequestMapping(value = "/passenger")
public class PassengerController {

    @Autowired
    private TrainService trainService;

    @RequestMapping(value = "/findTrains", method = RequestMethod.GET)
    public String findTrains(){
        return "findTrains";
    }

    @RequestMapping(value = "/findTrains", method = RequestMethod.POST)
    public ModelAndView findTrains(ModelAndView modelAndView,@RequestParam Map<String, String> params){
        modelAndView.addObject("trains",trainService.findTrains(params));
        modelAndView.setViewName("trainList");
        return modelAndView;
    }
}
