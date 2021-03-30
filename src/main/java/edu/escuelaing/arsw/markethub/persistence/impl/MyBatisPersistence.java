<<<<<<< HEAD
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
import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import edu.escuelaing.arsw.markethub.persistence.DAO.CategoriaDAO;
import edu.escuelaing.arsw.markethub.persistence.DAO.ImagenDAO;
import edu.escuelaing.arsw.markethub.persistence.DAO.ProductoDAO;
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

    @Override
    public void registerUser(UserMH user) {
        // TODO Auto-generated method stub

    }

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
    public Producto getProductById(Integer id) {
        return productoDAO.getProductById(id);
    }

    @Override
    public UserMH getUser(String usernameOrEmail) {
        return userMHDAO.getUserByUsername(usernameOrEmail);
    }

    @Override
    public void insertCategory(Categoria categoria) {
        categoriaDAO.insertCategory(categoria);
    }

    @Override
    public int insertImage(File image, Imagen imagenMH) {
        // Subir imagen a Cloudinary
        String key = "Y2xvdWRpbmFyeTovLzEzMTI0Njk1MzMyMzcxNjpuNHNPcVBfVlBDdU92SmRrcDZnMmpueG5BLVFAdDZmZDdnMXU=";
        String decodedString = new String(Base64.getDecoder().decode(key));
        Cloudinary cloudinary = new Cloudinary(decodedString);
        Map<?, ?> res = new HashMap<>();
        try {
            res = cloudinary.uploader().upload(image, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        imagenMH.setUrl(res.get("secure_url").toString());
        imagenDAO.insertImage(imagenMH);
        return imagenMH.getId();
    }

    public static void main(String[] args) {
        MyBatisPersistence mbp = new MyBatisPersistence();
        mbp.insertImage(new File(""), new Imagen());
    }

}
=======
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
import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import edu.escuelaing.arsw.markethub.persistence.DAO.CategoriaDAO;
import edu.escuelaing.arsw.markethub.persistence.DAO.ImagenDAO;
import edu.escuelaing.arsw.markethub.persistence.DAO.ProductoDAO;
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

    @Override
    public void registerUser(UserMH user) {
        // TODO Auto-generated method stub

    }

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
    public Producto getProductById(Integer id) {
        return productoDAO.getProductById(id);
    }

    @Override
    public UserMH getUser(String usernameOrEmail) {
        return userMHDAO.getUserByUsername(usernameOrEmail);
    }

    @Override
    public void insertCategory(Categoria categoria) {
        categoriaDAO.insertCategory(categoria);
    }

    @Override
    public int insertImage(File image, Imagen imagenMH) {
        // Subir imagen a Cloudinary
        String key = "Y2xvdWRpbmFyeTovLzEzMTI0Njk1MzMyMzcxNjpuNHNPcVBfVlBDdU92SmRrcDZnMmpueG5BLVFAdDZmZDdnMXU=";
        String decodedString = new String(Base64.getDecoder().decode(key));
        Cloudinary cloudinary = new Cloudinary(decodedString);
        Map<String, Object> res = new HashMap<>();
        try {
            res = cloudinary.uploader().upload(image, ObjectUtils.emptyMap());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;
        }
        imagenMH.setUrl(res.get("secure_url").toString());
        imagenDAO.insertImage(imagenMH);
        return imagenMH.getId();
    }

    @Override
    public List<Categoria> getAllCategories(){
        return categoriaDAO.getAllCategories();
    }

}
>>>>>>> main
