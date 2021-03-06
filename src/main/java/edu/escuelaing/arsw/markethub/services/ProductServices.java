package edu.escuelaing.arsw.markethub.services;

import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    @Qualifier("mockPersistence")
    Persistence persistence;

    public List<Producto> getProductos(){
        return persistence.getAllProducts();
    }

}
