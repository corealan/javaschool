package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import security.service.StationService;
import security.service.TrainService;

import java.util.Map;

@Controller
public class TrainController {

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;

    @GetMapping(value = "admin/getAllTrains")
    public ModelAndView allTrains(ModelAndView model,@RequestParam Map<String, String> params){
        model.addObject("trains",trainService.getAllTrains());
        model.setViewName("trainList");
        return model;
    }

    @PostMapping(value = "/admin/setTrainRoute")
    public ModelAndView setTrainRoute(ModelAndView model, @RequestParam Map<String, String> params){
        String message = trainService.addNewTrain(params);
        if(message != null){
            model.addObject("message", message);
            model.addObject("route", stationService.getStationsListFromString(params.get("route")));
            model.setViewName("routeStationSelect");
        }
        model.addObject("trains", trainService.getAllTrains());
        model.setViewName("trainList");
        return model;
    }
}
