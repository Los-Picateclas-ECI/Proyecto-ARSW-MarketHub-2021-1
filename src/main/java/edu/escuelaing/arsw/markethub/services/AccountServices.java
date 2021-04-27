package edu.escuelaing.arsw.markethub.services;

import edu.escuelaing.arsw.markethub.entities.Rol;
import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("AccountServices")
public class AccountServices {

    @Autowired
    @Qualifier("myBatisPersistence")
    private Persistence persistence;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    /*------------------------------------*/
    /*------------- USUARIOS -------------*/
    /*------------------------------------*/

    public void registerUser(UserMH userMH) {
        userMH.setPassword(passwordEncoder.encode(userMH.getPassword()));
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

    public void updateUser(UserMH user) {
        UserMH userMH = this.getUser(user.getUsername());
        if (user.getPassword().isEmpty() || user.getPassword() == null) {
            user.setPassword(userMH.getPassword());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        persistence.updateUser(user);
    }

    /*------------------------------------*/
    /*--------------- ROLES --------------*/
    /*------------------------------------*/

    public Rol getRoleByName(String name) {
        return persistence.getRoleByName(name);
    }
}
