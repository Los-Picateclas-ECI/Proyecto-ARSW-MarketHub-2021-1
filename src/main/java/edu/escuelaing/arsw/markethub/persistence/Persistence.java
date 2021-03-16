package edu.escuelaing.arsw.markethub.persistence;

public interface Persistence {
    boolean checkUserCredentials(String usernameOrEmail, String password);

    void registerUser(String username, String email, String password);
}
