package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import security.model.Station;
import security.service.StationService;
import security.service.TrainService;

import java.util.Map;

@Controller
@RequestMapping(value = "/passenger")
public class PassengerController {

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "/findTrains", method = RequestMethod.GET)
    public String findTrains(){
        return "findTrains";
    }

    @RequestMapping(value = "/findTrains", method = RequestMethod.POST)
    public ModelAndView findTrains(ModelAndView modelAndView,@RequestParam Map<String, String> params){
        modelAndView.addObject("trains",trainService.findTrains(params));
        modelAndView.addObject("role", 1);
        modelAndView.addObject("departure", stationService.getStationByName(params.get("departure")));
        modelAndView.addObject("destination",stationService.getStationByName(params.get("destination")));
        modelAndView.setViewName("trainList");
        return modelAndView;
    }

    @RequestMapping(value = "/getSchedule", method = RequestMethod.GET)
    public ModelAndView scheduleRequest(ModelAndView model){
        model.addObject("stations", stationService.getAllStations());
        model.setViewName("stationSchedule");
        return model;
    }

    @RequestMapping(value = "/getSchedule", method = RequestMethod.POST)
    public ModelAndView getSchedule(ModelAndView model, @RequestParam Map<String, String> params){
        Station station = stationService.getStationByName(params.get("station"));
        System.out.println(station);
        model.addObject("schedules",station.getSchedules());
        model.setViewName("stationSchedule");
        return model;
    }
}

