package edu.escuelaing.arsw.markethub.persistence;

import edu.escuelaing.arsw.markethub.entities.UserMH;

import java.util.List;

public interface Persistence {
    boolean checkUserCredentials(String usernameOrEmail, String password);

    void registerUser(String username, String email, String password);

    List<UserMH> getAllUsers();
}
