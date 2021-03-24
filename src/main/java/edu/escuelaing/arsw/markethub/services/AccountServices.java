package edu.escuelaing.arsw.markethub.services;

import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("AccountServices")
public class AccountServices {

    @Autowired
    @Qualifier("mockPersistence")
    private Persistence persistence;

    public void registerUser(UserMH userMH) {
        persistence.registerUser(userMH);
    }

    /**
     * Método para solicitar información del usuario
     *
     * @param user - usuario o correo del usuario
     * @return - informacion del usuario
     */
    public UserMH getUser(String user) {
        return user.contains("@") ? persistence.getUserByEmail(user) : persistence.getUserByUsername(user);
    }

}
