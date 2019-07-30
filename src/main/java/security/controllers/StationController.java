package security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import security.service.StationService;

import java.util.Map;

@Controller
public class StationController {

    @Autowired
    StationService stationService;

    @PostMapping(name = "/addNewStation")
    public String addNewStation(@RequestParam Map<String, String> paramMap){
        stationService.addNewStation(paramMap.get("stationName"), paramMap.get("leftNeighbourName"), paramMap.get("rightNeighbourName"));
        return "addNewStation";
    }

    @GetMapping(name = "/addNewStation")
    public String addNewStation(){
        return "addNewStation";
    }
}
