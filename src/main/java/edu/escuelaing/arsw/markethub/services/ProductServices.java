package edu.escuelaing.arsw.markethub.services;

import edu.escuelaing.arsw.markethub.entities.Categoria;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("ProductServices")
public class ProductServices {

    @Autowired
    @Qualifier("myBatisPersistence")
    Persistence persistence;

    public List<Producto> getProductos() {
        return persistence.getAllProducts();
    }

    public Producto getProductById(Integer id) {
        return persistence.getProductById(id);
    }

    public List<Categoria> getAllCategories() {
        return persistence.getAllCategories();
    }

}
