package security.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private Long id;
    @Column(name = "station_name", unique = true)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Station> adjacent;

    public List<Station> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(List<Station> adjacent) {
        this.adjacent = adjacent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAdjacent(Station station){
        adjacent.add(station);
    }
    public Station() {
        adjacent = new ArrayList<Station>();
    }
}
