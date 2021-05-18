package edu.escuelaing.arsw.markethub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import edu.escuelaing.arsw.markethub.entities.Mensaje;
import edu.escuelaing.arsw.markethub.persistence.Persistence;

@Service
@Component
public class RealTimeServices {
    
    @Autowired
    @Qualifier("myBatisPersistence")
    private Persistence persistence;

    /*------------------------------------*/
    /*--------------- CHAT ---------------*/
    /*------------------------------------*/

    public void saveMessage(Mensaje message) { 
        //TODO: Implementar 
    }
}
