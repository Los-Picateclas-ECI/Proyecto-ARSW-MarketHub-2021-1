package edu.escuelaing.arsw.markethub.persistence.impl;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.escuelaing.arsw.markethub.entities.Categoria;
import edu.escuelaing.arsw.markethub.entities.Imagen;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.entities.Rol;
import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import edu.escuelaing.arsw.markethub.persistence.DAO.CategoriaDAO;
import edu.escuelaing.arsw.markethub.persistence.DAO.ImagenDAO;
import edu.escuelaing.arsw.markethub.persistence.DAO.ProductoDAO;
import edu.escuelaing.arsw.markethub.persistence.DAO.RolDAO;
import edu.escuelaing.arsw.markethub.persistence.DAO.UserMHDAO;

@Component("myBatisPersistence")
public class MyBatisPersistence implements Persistence {

    @Autowired
    UserMHDAO userMHDAO;
    @Autowired
    ProductoDAO productoDAO;
    @Autowired
    CategoriaDAO categoriaDAO;
    @Autowired
    ImagenDAO imagenDAO;
    @Autowired
    RolDAO rolDAO;

    /*------------------------------------*/
    /*------------- USUARIOS -------------*/
    /*------------------------------------*/
    @Override
    public void registerUser(UserMH user) {
        // TODO Auto-generated method stub
    }

    @Override
    public UserMH getUser(String usernameOrEmail) {
        return userMHDAO.getUserByUsername(usernameOrEmail);
    }

    /*------------------------------------*/
    /*------------ PRODUCTOS -------------*/
    /*------------------------------------*/

    @Override
    public int registerProduct(Producto producto) {
        productoDAO.insertProduct(producto);
        return producto.getId();
    }

    @Override
    public List<Producto> getAllProducts() {
        System.out.println("MyBatis");
        return productoDAO.getAllProducts();
    }

    @Override
    public List<Producto> getProductsByCategory(String categoryName) {
        return productoDAO.getProductsByCategory(categoryName);
    }

    @Override
    public Producto getProductById(Integer id) {
        return productoDAO.getProductById(id);
    }

    @Override
    public List<Producto> getProductsByRating() {
        return productoDAO.getProductsByRating();
    }

    @Override
    public List<Producto> getProductsByLatest() {
        return productoDAO.getProductsByLatest();
    }

    /*------------------------------------*/
    /*------------ CATEGORÍAS ------------*/
    /*------------------------------------*/

    @Override
    public void insertCategory(Categoria categoria) {
        categoriaDAO.insertCategory(categoria);
    }

    @Override
    public List<Categoria> getAllCategories() {
        return categoriaDAO.getAllCategories();
    }

    @Override
    public Categoria getCategory(String name) {
        return categoriaDAO.getCategory(name);
    }

    /*------------------------------------*/
    /*------------- IMÁGENES -------------*/
    /*------------------------------------*/

    @Override
    public void insertImage(File image, Imagen imagenMH) {
        // Subir imagen a Cloudinary
        String key =
                "Y2xvdWRpbmFyeTovLzEzMTI0Njk1MzMyMzcxNjpuNHNPcVBfVlBDdU92SmRrcDZnMmpueG5BLVFAdDZmZDdnMXU=";
        String decodedString = new String(Base64.getDecoder().decode(key));
        Cloudinary cloudinary = new Cloudinary(decodedString);
        Map<?, ?> res = new HashMap<>();
        try {
            res = cloudinary.uploader().upload(image, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        imagenMH.setUrl(res.get("secure_url").toString());
        imagenDAO.insertImage(imagenMH);
    }

    /*------------------------------------*/
    /*--------------- ROLES --------------*/
    /*------------------------------------*/

    @Override
    public Rol getRoleByName(String name) {
        return rolDAO.getRoleByName(name);
    }

}
