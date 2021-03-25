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
    @Qualifier("myBatisPersistence")
    private Persistence persistence;

    public void registerUser(UserMH userMH) {
        persistence.registerUser(userMH);
    }

    /**
     * Método para solicitar información del usuario
     *
     * @param usernameOrEmail - usuario o correo del usuario
     * @return - información del usuario
     */
    public UserMH getUser(String usernameOrEmail) {
        return persistence.getUser(usernameOrEmail);
    }

}
