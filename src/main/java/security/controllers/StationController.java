package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import security.service.StationService;

import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class StationController {

    @Autowired
    StationService stationService;

    @PostMapping(value = "/addNewStation")
    public String addNewStation(@RequestParam Map<String, String> paramMap){
        stationService.addNewStation(paramMap.get("stationName"), paramMap.get("adjacentStation"), paramMap.get("adjacentStation2"));
        return "addNewStation";
    }

    @GetMapping(value = "/addNewStation")
    public String addNewStation(){
        return "addNewStation";
    }

    @GetMapping(value = "/routesRequest")
    public String routesRequest(){
        return "routesRequest";
    }

    @PostMapping(value = "/getRoutes")
    public ModelAndView getRoutes(ModelAndView model, @RequestParam Map<String, String> paramMap){
        model.addObject("routes",stationService.getRoutes(paramMap.get("departure"),paramMap.get("destination")));
        model.setViewName("posibleRoutes");
        return model;
    }

    @PostMapping(value = "/routeStationSelect")
    public ModelAndView routeStationSelect(ModelAndView model, @RequestParam Map<String,String> params){
        model.addObject("route",stationService.getStationsListFromString(params.get("route")));
        model.setViewName("routeStationSelect");
        return model;
    }
}
