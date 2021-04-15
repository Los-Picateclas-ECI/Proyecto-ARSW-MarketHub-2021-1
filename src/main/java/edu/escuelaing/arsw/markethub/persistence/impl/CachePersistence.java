package edu.escuelaing.arsw.markethub.persistence.impl;

import edu.escuelaing.arsw.markethub.entities.*;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component("cachePersistence")
public class CachePersistence implements Persistence {

    private static final Map<String, UserMH> userMap = new ConcurrentHashMap<String, UserMH>();
    private static final Map<Integer, Producto> productMap = new ConcurrentHashMap<Integer, Producto>();
    private static final Map<String, Categoria> categoriaMap = new ConcurrentHashMap<String, Categoria>();


    @Override
    public void registerUser(UserMH user) {
        userMap.put(user.getUsername(), user);
        userMap.put(user.getEmail(), user);
    }

    @Override
    public UserMH getUser(String usernameOrEmail) {
        return userMap.get(usernameOrEmail);
    }

    @Override
    public int registerProduct(Producto producto) {
        productMap.put(producto.getId(), producto);
        return producto.getId();
    }

    @Override
    public List<Producto> getAllProducts() {
        System.out.println("Cache");
        return new ArrayList<>(productMap.values());
    }

    @Override
    public List<Producto> getProductsByCategory(String categoryName) {
        List<Producto> productosCategory = new ArrayList<Producto>();
        for (Producto producto : productMap.values()){
            if(producto.getCategoria().getNombre().equals(categoryName)){
                productosCategory.add(producto);
            }
        }
        return productosCategory;
    }

    @Override
    public List<Producto> getProductsByRating() {
        List<Producto> productosRating = new ArrayList<Producto>(productMap.values());
        productosRating.sort((o1, o2) -> {
            if (o1.getPuntaje() > o2.getPuntaje()){
                return 1;
            }else {
                return 0;
            }
        });
        try {
            productosRating = productosRating.subList(0,4);
        }catch (Exception e) {
            return productosRating;
        }
        return productosRating;
    }

    @Override
    public List<Producto> getProductsByLatest() {
        List<Producto> productosRating = new ArrayList<Producto>(productMap.values());
        try {
            productosRating = productosRating.subList(productosRating.size()-8,productosRating.size());
        }catch (Exception e) {
            return productosRating;
        }
        return productosRating;
    }

    @Override
    public Producto getProductById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public void insertCategory(Categoria categoria) {
        categoriaMap.put(categoria.getNombre(), categoria);
    }

    @Override
    public List<Categoria> getAllCategories() {
        return (List<Categoria>) categoriaMap.values();
    }

    @Override
    public Categoria getCategory(String name) {
        return categoriaMap.get(name);
    }

    @Override
    public void insertImage(File image, Imagen imagenMH) {
        //Metodo no necesitado de implementar
    }

    @Override
    public Rol getRoleByName(String name) {
        //Metodo no necesitado de implementar
        return null;
    }

}
