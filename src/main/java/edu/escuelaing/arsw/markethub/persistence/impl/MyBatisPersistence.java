package edu.escuelaing.arsw.markethub.persistence.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import edu.escuelaing.arsw.markethub.entities.*;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import edu.escuelaing.arsw.markethub.persistence.dao.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    ComentarioDAO comentarioDAO;

    @Autowired
    CarritoCompraDAO carritoCompraDAO;

    /*------------------------------------*/
    /*------------- USUARIOS -------------*/
    /*------------------------------------*/
    @Override
    public void registerUser(UserMH user) {
        userMHDAO.registerUser(user);
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

    /*------------------------------------*/
    /*------------ COMENTARIOS -----------*/
    /*------------------------------------*/

    @Override
    public List<Comentario> getAllCommentsByProductID(Integer producto) {
        return comentarioDAO.getAllCommentsByProductID(producto);
    }

    @Override
    public Integer registerComment(Comentario comentario) {
        comentarioDAO.insertComment(comentario);
        return comentario.getId();
    }

    /*------------------------------------*/
    /*---------- CARRITO COMPRA ----------*/
    /*------------------------------------*/

    @Override
    public List<CarritoCompra> getCarritoProductsByUsername(String username) {
        return carritoCompraDAO.getCarritoProductsByUsername(username);
    }

    @Override
    public void deleteProductFromCar(String username, Integer productID) {
        carritoCompraDAO.deleteProductFromCar(username, productID);
    }

    @Override
    public void insertCarritoCompra(CarritoCompra carrito) {
        carritoCompraDAO.insertCarritoCompra(carrito);
    }

    @Override
    public void updateCantidad(CarritoCompra carrito) {
        carritoCompraDAO.updateCantidad(carrito);
    }

}
