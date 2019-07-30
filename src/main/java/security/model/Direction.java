package security.model;

import security.model.Station;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "directions")
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direction_id")
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "direction_station",
            joinColumns = @JoinColumn(name = "direction_id"),
            inverseJoinColumns = @JoinColumn(name = "station_id")
    )
    @OrderBy("dateCreated")
    private List<Station> stations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(LinkedList<Station> stations) {
        this.stations = stations;
    }

    public boolean containsStation(Station station){
        return stations.contains(station);
    }

    public void addStation(Station station){
        stations.add(station);
    }

    public void addStations(List<Station> stations){
        stations.addAll(stations);
    }

    public void insertNewStation(int index, Station station){
        stations.add(index, station);
    }

    public Direction() {
        stations = new LinkedList<Station>();
    }
}
