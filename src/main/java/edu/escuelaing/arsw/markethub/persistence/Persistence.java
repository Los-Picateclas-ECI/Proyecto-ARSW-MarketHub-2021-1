package edu.escuelaing.arsw.markethub.persistence;

import java.io.File;
import java.util.List;

import edu.escuelaing.arsw.markethub.entities.*;

public interface Persistence {

    /*------------------------------------*/
    /*------------- USUARIOS -------------*/
    /*------------------------------------*/
    void registerUser(UserMH user);

    UserMH getUser(String usernameOrEmail);

    /*------------------------------------*/
    /*------------ PRODUCTOS -------------*/
    /*------------------------------------*/

    void updateUser(UserMH user);

    void deleteUser(String username);

    int registerProduct(Producto producto);

    List<Producto> getAllProducts();

    List<Producto> getProductsByCategory(String categoryName);

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

    List<Comentario> getAllCommentsByProductID(Integer producto);

    Integer registerComment(Comentario comentario);

    List<CarritoCompra> getCarritoProductsByUsername(String username);

    void deleteProductFromCar(String username, Integer productID);

    void insertCarritoCompra(CarritoCompra carrito);

    void updateCantidad(CarritoCompra carrito);
}
