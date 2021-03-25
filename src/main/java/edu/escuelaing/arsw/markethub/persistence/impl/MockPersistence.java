package edu.escuelaing.arsw.markethub.persistence.impl;

import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.entities.Rol;
import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component("mockPersistence")
public class MockPersistence implements Persistence {

    private final HashMap<String, UserMH> usersByUsername = new HashMap<>();
    private final HashMap<String, UserMH> usersByEmail = new HashMap<>();
    private final HashMap<Integer, Producto> productById = new HashMap<>();

    public MockPersistence() {
        /*Roles*/
        Rol RolAdmin = new Rol(1, "ADMIN", "Administrador de la plataforma MarketHub");
        Rol RolUser = new Rol(1, "USER", "Usuario de la plataforma MarketHub");
        /* Usuarios */
        UserMH userMH = new UserMH("homie.simpson", 123456789, "3174414419", "homie.simpson@springfield.com", "Homero J Simpson", 36, "andapa",
                "742 de Evergreen Terrace", "CC", RolAdmin);
        registerUser(userMH);
        UserMH userMH2 = new UserMH("montgomery.burns", 987654321, "3075627419", "montgomery.burns@springfield.com", "Montgomery Burns", 87,
                "burns123", "Mansión Burns", "CC", RolUser);
        registerUser(userMH2);
        /* ¨Productos */
        registrarMuchosProductos();
    }

    @Override
    public void registerUser(UserMH user) {
        String username = user.getUsername();
        String email = user.getEmail();
        if (!usersByUsername.containsKey(username) && !usersByEmail.containsKey(email)) {
            usersByUsername.put(username, user);
            usersByEmail.put(email, user);
        }
    }

    @Override
    public void registerProduct(Integer id, String categoria, String nombre, List<String> imagen, Integer precio,
                                String descripcion, Double puntaje, Integer cantidad) {
        if (!productById.containsKey(id)) {
            Producto producto = new Producto(id, categoria, nombre, imagen, precio, descripcion, puntaje, cantidad);
            productById.put(id, producto);
        }
    }

    @Override
    public List<Producto> getAllProducts() {
        return new ArrayList<Producto>(productById.values());
    }

    @Override
    public Producto getProductoById(Integer id) {
        return productById.get(id);
    }

    @Override
    public UserMH getUser(String usernameOrEmail) {
        if (usersByUsername.containsKey(usernameOrEmail)) {
            return usersByUsername.get(usernameOrEmail);
        } else if (usersByEmail.containsKey(usernameOrEmail)){
            return usersByEmail.get(usernameOrEmail);
        }
        return null;
    }

    private void registrarMuchosProductos() {
        ArrayList<String> imagenes = new ArrayList<>();
        imagenes.add("../images/product-1.jpg");
        imagenes.add("../images/gallery-1.jpg");
        imagenes.add("../images/gallery-2.jpg");
        imagenes.add("../images/gallery-3.jpg");
        imagenes.add("../images/gallery-4.jpg");
        registerProduct(1, "ROPA", "Red Printed T-shirt", imagenes, 50000, "Camiseta Roja Lo mas de aleta", 4.0, 20);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-2.jpg");
        imagenes.add("../images/product-2.jpg");
        imagenes.add("../images/product-2.jpg");
        imagenes.add("../images/product-2.jpg");
        imagenes.add("../images/product-2.jpg");
        registerProduct(2, "ROPA", "Zapatillas Negras HRX", imagenes, 320000, "Zapatillas negras ultra pelles", 3.5, 2);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-3.jpg");
        imagenes.add("../images/product-3.jpg");
        imagenes.add("../images/product-3.jpg");
        imagenes.add("../images/product-3.jpg");
        imagenes.add("../images/product-3.jpg");
        registerProduct(3, "ROPA", "Pantalon Gris Ultra 4k", imagenes, 60000, "Pantalos gris hiper pelle", 4.5, 43);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-4.jpg");
        imagenes.add("../images/product-4.jpg");
        imagenes.add("../images/product-4.jpg");
        imagenes.add("../images/product-4.jpg");
        imagenes.add("../images/product-4.jpg");
        registerProduct(4, "ROPA", "Camisa Polo Azul PUMA", imagenes, 100000, "Camisa mas pelle HD", 4.0, 29);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-5.jpg");
        imagenes.add("../images/product-5.jpg");
        imagenes.add("../images/product-5.jpg");
        imagenes.add("../images/product-5.jpg");
        imagenes.add("../images/product-5.jpg");
        registerProduct(5, "ROPA", "Zapatillas Grises PUMA", imagenes, 520000, "Zapatillas grises ultra pelles", 4.0,
                45);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-6.jpg");
        imagenes.add("../images/product-6.jpg");
        imagenes.add("../images/product-6.jpg");
        imagenes.add("../images/product-6.jpg");
        imagenes.add("../images/product-6.jpg");
        registerProduct(6, "ROPA", "Camisa Negra PUMA", imagenes, 40000, "Camisa PUMIX 1080p", 3.5, 432);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-7.jpg");
        imagenes.add("../images/product-7.jpg");
        imagenes.add("../images/product-7.jpg");
        imagenes.add("../images/product-7.jpg");
        imagenes.add("../images/product-7.jpg");
        registerProduct(7, "ROPA", "Medias HRX", imagenes, 20000, "Medias Medio Medio", 4.5, 204);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-8.jpg");
        imagenes.add("../images/product-8.jpg");
        imagenes.add("../images/product-8.jpg");
        imagenes.add("../images/product-8.jpg");
        imagenes.add("../images/product-8.jpg");
        registerProduct(8, "ROPA", "Reloj Negro Fossil", imagenes, 3200000, "Ultra fino 4k el reloj", 4.0, 5);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-9.jpg");
        imagenes.add("../images/product-9.jpg");
        imagenes.add("../images/product-9.jpg");
        imagenes.add("../images/product-9.jpg");
        imagenes.add("../images/product-9.jpg");
        registerProduct(9, "ROPA", "Reloj Roadster Negro", imagenes, 1203000, "Relojito aspero", 4.0, 54);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-10.jpg");
        imagenes.add("../images/product-10.jpg");
        imagenes.add("../images/product-10.jpg");
        imagenes.add("../images/product-10.jpg");
        imagenes.add("../images/product-10.jpg");
        registerProduct(10, "ROPA", "Zapatillas Deportivas HRX", imagenes, 200000, "Zapatillas negras ultra pelles",
                4.5, 20);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-11.jpg");
        imagenes.add("../images/product-11.jpg");
        imagenes.add("../images/product-11.jpg");
        imagenes.add("../images/product-11.jpg");
        imagenes.add("../images/product-11.jpg");
        registerProduct(11, "ROPA", "Zapatillas Grises HRX", imagenes, 125999, "Zapatillas grises ultra pelles", 4.5,
                54);

        imagenes = new ArrayList<>();
        imagenes.add("../images/product-12.jpg");
        imagenes.add("../images/product-12.jpg");
        imagenes.add("../images/product-12.jpg");
        imagenes.add("../images/product-12.jpg");
        imagenes.add("../images/product-12.jpg");
        registerProduct(12, "ROPA", "Pantalon NIKE negro", imagenes, 150000, "Severo Yoger", 4.0, 20);
    }

}
