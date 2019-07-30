package security.service;

import security.model.Direction;
import security.model.Station;

import java.util.List;

public interface StationService {

    void saveStation(Station station);
    Station getStationById(long id);
    List<Direction> getStationDirections(Station station);
    void addDirectionToStation(Direction direction, Station station);
    void addStationToDirection(Station station, Direction direction);
    void addNewStation(String name, String leftNeighbourName, String rightNeighbourName);
    List<Direction> getDirectionsThroughTwoStations(Station a, Station b);
    List<Station> getAllStations();
}
