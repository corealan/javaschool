package security.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "train_number")
    private Integer trainNumber;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy(value = "departureTime")
    private List<Schedule> schedules;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Station> route;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;



    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void addSchedule(Schedule schedule){
        schedules.add(schedule);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Integer getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Integer trainNumber) {
        this.trainNumber = trainNumber;
    }

    public List<Station> getRoute() {
        return route;
    }

    public void setRoute(List<Station> route) {
        this.route = route;
    }

    public Train() {
        schedules = new ArrayList<Schedule>();
    }
}
