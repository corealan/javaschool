package security.service;

import security.model.Station;

import java.util.LinkedList;
import java.util.List;

public interface StationService {

    void saveStation(Station station);
    Station getStationById(long id);
    void addNewStation(String name, String adjacentName);
    List<Station> getAllStations();
    Station getStationByName(String name);
    List<LinkedList<Station>> getRoutes(String a, String b);
}
