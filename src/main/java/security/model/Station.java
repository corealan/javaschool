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

    @ManyToMany(mappedBy = "stations")
    private List<Direction> directions;

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

    public List<Direction> getDirections() {
        return directions;
    }

    public void setDirections(ArrayList<Direction> directions) {
        this.directions = directions;
    }

    public void addDirection(Direction direction){
        directions.add(direction);
    }

    public Station() {
        directions = new LinkedList<Direction>();
    }
}
