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

    @RequestMapping(value = "/addNewStation",method = RequestMethod.POST)
    public String addNewStation(@RequestParam Map<String, String> paramMap){
        stationService.addNewStation(paramMap.get("stationName"), paramMap.get("adjacentStation"), paramMap.get("adjacentStation2"));
        return "addNewStation";
    }

    @RequestMapping(value = "/addNewStation", method = RequestMethod.GET)
    public String addNewStation(){
        return "addNewStation";
    }

    @RequestMapping(value = "/routesRequest", method = RequestMethod.GET)
    public String routesRequest(){
        return "routesRequest";
    }

    @RequestMapping(value = "/getRoutes", method = RequestMethod.POST)
    public ModelAndView getRoutes(ModelAndView model, @RequestParam Map<String, String> paramMap){
        model.addObject("routes",stationService.getRoutes(paramMap.get("departure"),paramMap.get("destination")));
        model.setViewName("posibleRoutes");
        return model;
    }

    @RequestMapping(value = "/routeStationSelect", method = RequestMethod.POST)
    public ModelAndView routeStationSelect(ModelAndView model, @RequestParam Map<String,String> params){
        model.addObject("route",stationService.getStationsListFromString(params.get("route")));
        model.setViewName("routeStationSelect");
        return model;
    }
}
