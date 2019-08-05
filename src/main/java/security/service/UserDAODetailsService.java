package security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import security.dao.security.PassengerDAO;
import security.model.security.Passenger;

@Service
public class UserDAODetailsService implements UserDetailsService {


    private PassengerDAO passengerDAO;
    @Autowired
    public void setPassengerDAO(PassengerDAO passengerDAO) {
        this.passengerDAO = passengerDAO;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Passenger passenger = passengerDAO.findByUsername(username);
        if (passenger != null){
            return passenger;
        }
        throw new UsernameNotFoundException("Passenger " + username + " not found");
    }
}
