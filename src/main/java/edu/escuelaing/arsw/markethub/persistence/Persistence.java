package edu.escuelaing.arsw.markethub.persistence;

import edu.escuelaing.arsw.markethub.entities.Imagen;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.entities.UserMH;

import java.util.List;

public interface Persistence {

    void registerUser(UserMH user);

    void registerProduct(Integer id, String categoria, String nombre, List<Imagen> imagen, Integer precio,
            String descripcion, Double puntaje, Integer cantidad);

    List<Producto> getAllProducts();

    Producto getProductoById(Integer id);

    UserMH getUser(String usernameOrEmail);

}
