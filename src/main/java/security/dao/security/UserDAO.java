package security.dao.security;


import security.model.security.User;

public interface UserDAO {

    void saveUser(User user);
    User findByUsername(String username);
}
