package edu.escuelaing.arsw.markethub.persistence.impl;

import java.util.List;

import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.Persistence;

public class MyBatisPersistence implements Persistence {

    @Override
    public boolean checkUserCredentials(String usernameOrEmail, String password) {
        // TODO Auto-generated method stub
        return false;
    }

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
    public List<UserMH> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
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
    public UserMH getUserByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserMH getUserByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }

}
