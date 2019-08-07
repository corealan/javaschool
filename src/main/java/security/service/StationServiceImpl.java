package security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import security.dao.ScheduleDAO;
import security.dao.StationDAO;
import security.model.Schedule;
import security.model.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
@Service
@Transactional
public class StationServiceImpl implements StationService {

    private static List<LinkedList<Station>> routes = new LinkedList<LinkedList<Station>>();

    @Autowired
    private StationDAO stationDAO;

    public void saveStation(Station station) {
        stationDAO.saveStation(station);
    }

    public Station getStationById(long id) {
        return stationDAO.getStationById(id);
    }

    public  Station getStationByName(String name){
        return stationDAO.getStationByName(name);
    }

    public List<Station> getAllStations() {
        return stationDAO.getAllStations();
    }

    public void addNewStation(String name, String adjacentName, String adjacentName2) {
        Station station = getStationByName(name);
        Station adjacent = getStationByName(adjacentName);
        Station adjacent2 = getStationByName(adjacentName2);

        if(station == null) {
            station = new Station();
            station.setName(name);

            if (adjacent != null && adjacent2 == null) {
                station.addAdjacent(adjacent);
                adjacent.addAdjacent(station);
                saveStation(station);
            } else
                if(adjacent != null && adjacent2 != null){
                    addStationBetween(station, adjacent, adjacent2);
            }
            else saveStation(station);
        } else
            if(!station.getAdjacent().contains(adjacent) && station.getId()!=adjacent.getId()){
            station.addAdjacent(adjacent);
            adjacent.addAdjacent(station);
            saveStation(station);
        }
    }

    private void addStationBetween(Station newStation, Station adjacent1, Station adjacent2){
        newStation.addAdjacent(adjacent1);
        adjacent1.addAdjacent(newStation);
        adjacent1.removeAdjacent(adjacent2);

        newStation.addAdjacent(adjacent2);
        adjacent2.addAdjacent(newStation);
        adjacent2.removeAdjacent(adjacent1);

        saveStation(newStation);
    }

    public List<LinkedList<Station>> getRoutes(String departure, String destination){
        routes.clear();
        Station departureStation = getStationByName(departure);
        LinkedList<Station> visited = new LinkedList<Station>();
        visited.add(departureStation);
        depthFirst(destination, visited);
        return routes;
    }

    public List<Station> getStationsListFromString(String ids) {
        List<Station> result = new ArrayList<Station>();
        String str = ids.substring(1, ids.length()-1);
        List<String> strings = Arrays.asList(str.split(", "));

        for(String s : strings){
            result.add(getStationById(Long.parseLong(s)));
        }
        return result;
    }

    private static void depthFirst(String destination,LinkedList<Station> visited){

        LinkedList<Station> nodes = new LinkedList<Station>(visited.getLast().getAdjacent());
        for(Station node : nodes){
            if(visited.contains(node)){
                continue;
            }
            if(node.getName().equals(destination)){
                visited.add(node);
                routes.add(new LinkedList<Station>(visited));
                visited.removeLast();
                break;
            }
        }
        for(Station node : nodes){
            if(visited.contains(node) || node.getName().equals(destination)){
                continue;
            }
            visited.addLast(node);
            depthFirst(destination, visited);
            visited.removeLast();
        }
    }
}
