package edu.escuelaing.arsw.markethub.persistence.impl;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import edu.escuelaing.arsw.markethub.persistence.Persistence;

@Component("mockPersistence")
public class MockPersistence implements Persistence {

    private HashMap<String, User> usersByUsername;
    private HashMap<String, User> usersByEmail;

    @Override
    public boolean checkUserCredentials(String usernameOrEmail, String password) {
        User user;
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
    public void registerUser(String username, String email, String password) {
        if (!usersByUsername.containsKey(username) && !usersByEmail.containsKey(email)) {
            User user = new User(username, email, password);
            usersByUsername.put(username, user);
            usersByEmail.put(email, user);
        }
    }

    class User {
        private String username;
        private String password;
        private String email;

        public User(String username, String email, String password) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
