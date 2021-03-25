package edu.escuelaing.arsw.markethub.persistence.impl;

import java.util.List;

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
        return productoDAO.getLatestId();
    }

    @Override
    public List<Producto> getAllProducts() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Producto getProductoById(Integer id) {
        // TODO Auto-generated method stub
        return null;
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
    public int insertImage(Imagen imagen) {
        imagenDAO.insertImage(imagen);
        return imagenDAO.getLatestId();
    }

}
