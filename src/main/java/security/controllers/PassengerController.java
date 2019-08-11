package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import security.model.Station;
import security.service.StationService;
import security.service.TrainService;

import java.util.Map;

@Controller
public class PassengerController {

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;


    @GetMapping(value = "/")
    public String passenger(){
        return "passenger";
    }

    @PostMapping(value = "/findTrains")
    public ModelAndView findTrains(ModelAndView modelAndView,@RequestParam Map<String, String> params){
        modelAndView.addObject("trains",trainService.findTrains(params));
        modelAndView.addObject("role", 1);
        modelAndView.addObject("departure", stationService.getStationByName(params.get("departure")));
        modelAndView.addObject("destination",stationService.getStationByName(params.get("destination")));
        modelAndView.setViewName("trainList");
        return modelAndView;
    }

    @GetMapping(value = "/getSchedule")
    public ModelAndView scheduleRequest(ModelAndView model){
        model.addObject("stations", stationService.getAllStations());
        model.setViewName("stationSchedule");
        return model;
    }

    @PostMapping(value = "/getSchedule")
    public ModelAndView getSchedule(ModelAndView model, @RequestParam Map<String, String> params){
        Station station = stationService.getStationByName(params.get("station"));
        System.out.println(station);
        model.addObject("schedules",station.getSchedules());
        model.setViewName("stationSchedule");
        return model;
    }
}

