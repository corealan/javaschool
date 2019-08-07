package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "admin/getAllTrains", method = RequestMethod.GET)
    public ModelAndView allTrains(ModelAndView model,@RequestParam Map<String, String> params){
        model.addObject("trains",trainService.getAllTrains());
        model.setViewName("trainList");
        return model;
    }

    @RequestMapping(value = "/admin/setTrainRoute", method = RequestMethod.POST)
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
