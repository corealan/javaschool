package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import security.service.TrainService;

import java.util.Map;

@Controller
public class TrainController {

    @Autowired
    private TrainService trainService;

    @RequestMapping(value = "/setTrainRoute", method = RequestMethod.POST)
    public String setTrainRoute(@RequestParam Map<String,String> params){
        trainService.addNewTrain(params);
        return "";
    }
}
