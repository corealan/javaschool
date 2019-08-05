package security.service;

import security.model.security.Passenger;

import java.util.Map;

public interface PassengerService {
    void savePassenger(Passenger passenger);
    Passenger findByUsername(String username);
    void passengerRegistration(Map<String, String> paramMap);
}
