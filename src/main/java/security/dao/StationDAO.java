package security.dao;

import security.model.Station;

import java.util.List;

public interface StationDAO {

    List<Station> getAllStations();

    void saveStation(Station station);

    Station getStationById(long id);

    Station getStationByName(String name);


}
