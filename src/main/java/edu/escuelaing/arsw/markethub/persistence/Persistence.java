package edu.escuelaing.arsw.markethub.persistence;

import java.io.File;
import java.util.List;
import edu.escuelaing.arsw.markethub.entities.Categoria;
import edu.escuelaing.arsw.markethub.entities.Imagen;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.entities.Rol;
import edu.escuelaing.arsw.markethub.entities.UserMH;

public interface Persistence {

    /*------------------------------------*/
    /*------------- USUARIOS -------------*/
    /*------------------------------------*/
    void registerUser(UserMH user);

    UserMH getUser(String usernameOrEmail);

    /*------------------------------------*/
    /*------------ PRODUCTOS -------------*/
    /*------------------------------------*/

    int registerProduct(Producto producto);

    List<Producto> getAllProducts();

    List<Producto> getProductsByRating();

    List<Producto> getProductsByLatest();

    Producto getProductById(Integer id);

    /*------------------------------------*/
    /*------------ CATEGORÍAS ------------*/
    /*------------------------------------*/

    void insertCategory(Categoria categoria);

    List<Categoria> getAllCategories();

    Categoria getCategory(String name);

    /*------------------------------------*/
    /*------------- IMÁGENES -------------*/
    /*------------------------------------*/

    void insertImage(File image, Imagen imagenMH);

    /*------------------------------------*/
    /*--------------- ROLES --------------*/
    /*------------------------------------*/

    Rol getRoleByName(String name);
}
