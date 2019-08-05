package security.dao.security;


import security.model.security.Passenger;

public interface PassengerDAO {

    void savePassenger(Passenger passenger);
    Passenger findByUsername(String username);
}
