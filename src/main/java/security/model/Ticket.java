package security.model;

import security.model.security.Passenger;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departure_station_id")
    private Station departure;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination_station_id")
    private Station destination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }


    public Station getDeparture() {
        return departure;
    }

    public void setDeparture(Station departure) {
        this.departure = departure;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
