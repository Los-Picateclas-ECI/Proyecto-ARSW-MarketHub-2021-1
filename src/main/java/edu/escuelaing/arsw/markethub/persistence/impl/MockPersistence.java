package edu.escuelaing.arsw.markethub.persistence.impl;

import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component("mockPersistence")
public class MockPersistence implements Persistence {

    private final HashMap<String, UserMH> usersByUsername = new HashMap<>();
    private final HashMap<String, UserMH> usersByEmail = new HashMap<>();

    public MockPersistence() {
        registerUser("homie.simpson", "homie.simpson@springfield.com", "andapa", "ADMIN");
        registerUser("WTF", "W@T.F", "FTW", "USER");
    }

    @Override
    public boolean checkUserCredentials(String usernameOrEmail, String password) {
        UserMH user;
        if (usersByUsername.containsKey(usernameOrEmail)) {
            user = usersByUsername.get(usernameOrEmail);
        } else if (usersByEmail.containsKey(usernameOrEmail)) {
            user = usersByEmail.get(usernameOrEmail);
        } else {
            return false;
        }

        return password.equals(user.getPassword());
    }

    @Override
    public void registerUser(String username, String email, String password, String role) {
        if (!usersByUsername.containsKey(username) && !usersByEmail.containsKey(email)) {
            UserMH user = new UserMH(username, email, password, role);
            usersByUsername.put(username, user);
            usersByEmail.put(email, user);
        }
    }

    @Override
    public List<UserMH> getAllUsers() {
        return new ArrayList<UserMH>(usersByUsername.values());
    }

    @Override
    public UserMH getUserByUsername(String username) {
        if (usersByUsername.containsKey(username)) {
            return usersByUsername.get(username);
        }
        return null;
    }

    @Override
    public UserMH getUserByEmail(String email) {
        if (usersByEmail.containsKey(email)) {
            return usersByEmail.get(email);
        }
        return null;
    }

}
