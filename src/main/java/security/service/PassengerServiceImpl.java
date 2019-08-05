package security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import security.dao.security.PassengerDAO;
import security.dao.security.RoleDAO;
import security.model.security.Passenger;
import security.model.security.Role;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerDAO passengerDAO;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    RoleDAO roleDAO;

    public void savePassenger(Passenger passenger) {
        passengerDAO.savePassenger(passenger);
    }

    public Passenger findByUsername(String username) {
        return passengerDAO.findByUsername(username);
    }

    public void passengerRegistration(Map<String, String> paramMap) {
        Passenger passenger = new Passenger();
        passenger.setUsername(paramMap.get("username"));
        passenger.setPassword(encoder.encode(paramMap.get("password")));
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleDAO.getRoleById(2L));
        passenger.setRoles(roles);

        passenger.setFirstName(paramMap.get("firstName"));
        passenger.setLastName(paramMap.get("lastName"));
        Date date = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateFormat.parse(paramMap.get("DOB"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        passenger.setDateOfBirth(date);
        savePassenger(passenger);
    }
}
