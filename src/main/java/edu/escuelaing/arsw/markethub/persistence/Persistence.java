<<<<<<< HEAD
package edu.escuelaing.arsw.markethub.persistence;

import java.io.File;
import java.util.List;

import edu.escuelaing.arsw.markethub.entities.Categoria;
import edu.escuelaing.arsw.markethub.entities.Imagen;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.entities.UserMH;

public interface Persistence {

    // ------------------------- Usuarios --------------------------------
    void registerUser(UserMH user);

    UserMH getUser(String usernameOrEmail);

    // ------------------------- Productos -------------------------------

    int registerProduct(Producto producto);

    List<Producto> getAllProducts();

    Producto getProductById(Integer id);

    // ------------------------ Categorias -------------------------------

    void insertCategory(Categoria categoria);

    // ------------------------ Imágenes ----------------------------------

    int insertImage(File image, Imagen imagenMH);
}
=======
package edu.escuelaing.arsw.markethub.persistence;

import java.io.File;
import java.util.List;

import edu.escuelaing.arsw.markethub.entities.Categoria;
import edu.escuelaing.arsw.markethub.entities.Imagen;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.entities.UserMH;

public interface Persistence {

    // ------------------------- Usuarios --------------------------------
    void registerUser(UserMH user);

    UserMH getUser(String usernameOrEmail);

    // ------------------------- Productos -------------------------------

    int registerProduct(Producto producto);

    List<Producto> getAllProducts();

    Producto getProductById(Integer id);

    // ------------------------ Categorias -------------------------------

    void insertCategory(Categoria categoria);

    // ------------------------ Imágenes ----------------------------------

    int insertImage(File image, Imagen imagenMH);

    List<Categoria> getAllCategories();
}
>>>>>>> main
