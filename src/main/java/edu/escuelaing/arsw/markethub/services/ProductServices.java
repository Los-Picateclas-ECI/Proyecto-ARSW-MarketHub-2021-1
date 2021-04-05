package edu.escuelaing.arsw.markethub.services;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import edu.escuelaing.arsw.markethub.entities.Categoria;
import edu.escuelaing.arsw.markethub.entities.Imagen;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.persistence.Persistence;

@Service
@Component("ProductServices")
public class ProductServices {

    @Autowired
    @Qualifier("myBatisPersistence")
    Persistence persistence;

    /*------------------------------------*/
    /*------------ PRODUCTOS -------------*/
    /*------------------------------------*/

    public List<Producto> getProductos() {
        return persistence.getAllProducts();
    }

    public Producto getProductById(Integer id) {
        return persistence.getProductById(id);
    }

    public void insertProduct(Producto product) {
        persistence.registerProduct(product);
    }

    /*------------------------------------*/
    /*------------ CATEGORÍAS ------------*/
    /*------------------------------------*/
    public List<Categoria> getAllCategories() {
        return persistence.getAllCategories();
    }

    public Categoria getCategory(String name) {
        return persistence.getCategory(name);
    }

    /*------------------------------------*/
    /*------------- IMÁGENES -------------*/
    /*------------------------------------*/
    public void insertImage(File image, Imagen imagenMH) {
        persistence.insertImage(image, imagenMH);
    }
}
