package edu.escuelaing.arsw.markethub.persistence.impl;

import java.util.List;

import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.DAO.UserMHDAO;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myBatisPersistence")
public class MyBatisPersistence implements Persistence {

    @Autowired
    UserMHDAO userMHDAO;

    @Override
    public void registerUser(UserMH user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void registerProduct(Integer id, String categoria, String nombre, List<String> imagen, Integer precio,
            String descripcion, Double puntaje, Integer cantidad) {
        // TODO Auto-generated method stub

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

}
