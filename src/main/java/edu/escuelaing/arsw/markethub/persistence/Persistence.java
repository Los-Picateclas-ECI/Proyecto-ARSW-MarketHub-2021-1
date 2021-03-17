package edu.escuelaing.arsw.markethub.persistence;

import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.entities.UserMH;

import java.util.List;

public interface Persistence {

    boolean checkUserCredentials(String usernameOrEmail, String password);

    void registerUser(String username, String email, String password, String role);

    void registerProduct(Integer id, String nombre, List imagen, Integer precio, String descripcion, Double puntaje, Integer cantidad);

    List<UserMH> getAllUsers();
	
    List<Producto> getAllProducts();

    Producto getProductoById(Integer id);

    UserMH getUserByUsername(String username);

    UserMH getUserByEmail(String email);
	
}
