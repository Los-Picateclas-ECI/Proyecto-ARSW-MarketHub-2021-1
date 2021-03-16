package edu.escuelaing.arsw.markethub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.escuelaing.arsw.markethub.persistence.Persistence;

public class AccountServices {

    @Autowired
    @Qualifier("mockPersistence")
    private Persistence persistence;

    public void registerUser(String username, String email, String password, String role) {
        persistence.registerUser(username, email, password, role);
    }

    public boolean loginUser(String usernameOrEmail, String password) {
        return persistence.checkUserCredentials(usernameOrEmail, password);
    }
}
