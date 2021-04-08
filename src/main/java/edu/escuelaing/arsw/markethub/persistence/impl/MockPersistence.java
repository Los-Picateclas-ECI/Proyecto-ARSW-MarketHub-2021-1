package edu.escuelaing.arsw.markethub.persistence.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;
import edu.escuelaing.arsw.markethub.entities.Categoria;
import edu.escuelaing.arsw.markethub.entities.Imagen;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.entities.Rol;
import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.Persistence;

@Component("mockPersistence")
public class MockPersistence implements Persistence {

    private final HashMap<String, UserMH> usersByUsername = new HashMap<>();
    private final HashMap<String, UserMH> usersByEmail = new HashMap<>();
    private final HashMap<Integer, Producto> productById = new HashMap<>();
    private final HashMap<String, Categoria> categoryById = new HashMap<>();

    public MockPersistence() {
        /* Roles */
        Rol RolAdmin = new Rol(1, "ADMIN", "Administrador de la plataforma MarketHub");
        Rol RolUser = new Rol(1, "USER", "Usuario de la plataforma MarketHub");
        /* Usuarios */
        UserMH userMH = new UserMH("homie.simpson", 123456789, "3174414419",
                "homie.simpson@springfield.com", "Homero J Simpson", 36, "andapa",
                "742 de Evergreen Terrace", "CC", RolAdmin);
        registerUser(userMH);
        UserMH userMH2 = new UserMH("montgomery.burns", 987654321, "3075627419",
                "montgomery.burns@springfield.com", "Montgomery Burns", 87, "burns123",
                "Mansión Burns", "CC", RolUser);
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
    public int registerProduct(Producto producto) {
        int id = producto.getId();
        if (!productById.containsKey(id)) {
            productById.put(id, producto);
        }
        return id;
    }

    @Override
    public List<Producto> getAllProducts() {
        return new ArrayList<Producto>(productById.values());
    }

    @Override
    public Producto getProductById(Integer id) {
        return productById.get(id);
    }

    @Override
    public UserMH getUser(String usernameOrEmail) {
        if (usersByUsername.containsKey(usernameOrEmail)) {
            return usersByUsername.get(usernameOrEmail);
        } else if (usersByEmail.containsKey(usernameOrEmail)) {
            return usersByEmail.get(usernameOrEmail);
        }
        return null;
    }

    @Override
    public void insertCategory(Categoria categoria) {
        if (!categoryById.containsKey(categoria.getNombre())) {
            categoryById.put(categoria.getNombre(), categoria);
        }
    }

    @Override
    public void insertImage(File image, Imagen imagenMH) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Categoria> getAllCategories() {
        return null;
    }

    @Override
    public Categoria getCategory(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    private void registrarMuchosProductos() {
        Categoria cat = new Categoria("Ropa", "Todos los productos para que estés a la moda.");
        insertCategory(cat);

        Producto prod = new Producto(1, cat, "Red Printed T-shirt", 50000,
                "Camiseta Roja Lo mas de aleta", 4.0, 20);
        ArrayList<Imagen> imagenes = new ArrayList<>();
        imagenes.add(new Imagen(1, prod.getId(), "/img/product-1.jpg"));
        imagenes.add(new Imagen(2, prod.getId(), "/img/gallery-1.jpg"));
        imagenes.add(new Imagen(3, prod.getId(), "/img/gallery-2.jpg"));
        imagenes.add(new Imagen(4, prod.getId(), "/img/gallery-3.jpg"));
        imagenes.add(new Imagen(5, prod.getId(), "/img/gallery-4.jpg"));
        prod.setImagenes(imagenes);
        registerProduct(prod);

        prod = new Producto(2, cat, "Zapatillas Negras HRX", 320000,
                "Zapatillas negras ultra pelles", 3.5, 2);
        imagenes = new ArrayList<>();
        imagenes.add(new Imagen(6, prod.getId(), "/img/product-2.jpg"));
        imagenes.add(new Imagen(7, prod.getId(), "/img/product-2.jpg"));
        imagenes.add(new Imagen(8, prod.getId(), "/img/product-2.jpg"));
        imagenes.add(new Imagen(9, prod.getId(), "/img/product-2.jpg"));
        imagenes.add(new Imagen(10, prod.getId(), "/img/product-2.jpg"));
        prod.setImagenes(imagenes);
        registerProduct(prod);

        prod = new Producto(3, cat, "Pantalon Gris Ultra 4k", 60000, "Pantalos gris hiper pelle",
                4.5, 43);
        imagenes = new ArrayList<>();
        imagenes.add(new Imagen(11, prod.getId(), "/img/product-3.jpg"));
        imagenes.add(new Imagen(12, prod.getId(), "/img/product-3.jpg"));
        imagenes.add(new Imagen(13, prod.getId(), "/img/product-3.jpg"));
        imagenes.add(new Imagen(14, prod.getId(), "/img/product-3.jpg"));
        imagenes.add(new Imagen(15, prod.getId(), "/img/product-3.jpg"));
        prod.setImagenes(imagenes);
        registerProduct(prod);

        prod = new Producto(4, cat, "Camisa Polo Azul PUMA", 100000, "Camisa mas pelle HD", 4.0,
                29);
        imagenes = new ArrayList<>();
        imagenes.add(new Imagen(16, prod.getId(), "/img/product-4.jpg"));
        imagenes.add(new Imagen(17, prod.getId(), "/img/product-4.jpg"));
        imagenes.add(new Imagen(18, prod.getId(), "/img/product-4.jpg"));
        imagenes.add(new Imagen(19, prod.getId(), "/img/product-4.jpg"));
        imagenes.add(new Imagen(20, prod.getId(), "/img/product-4.jpg"));
        prod.setImagenes(imagenes);
        registerProduct(prod);

        prod = new Producto(5, cat, "Zapatillas Grises PUMA", 520000,
                "Zapatillas grises ultra pelles", 4.0, 45);
        imagenes = new ArrayList<>();
        imagenes.add(new Imagen(21, prod.getId(), "/img/product-5.jpg"));
        imagenes.add(new Imagen(22, prod.getId(), "/img/product-5.jpg"));
        imagenes.add(new Imagen(23, prod.getId(), "/img/product-5.jpg"));
        imagenes.add(new Imagen(24, prod.getId(), "/img/product-5.jpg"));
        imagenes.add(new Imagen(25, prod.getId(), "/img/product-5.jpg"));
        prod.setImagenes(imagenes);
        registerProduct(prod);

        prod = new Producto(6, cat, "Camisa Negra PUMA", 40000, "Camisa PUMIX 1080p", 3.5, 432);
        imagenes = new ArrayList<>();
        imagenes.add(new Imagen(26, prod.getId(), "/img/product-6.jpg"));
        imagenes.add(new Imagen(27, prod.getId(), "/img/product-6.jpg"));
        imagenes.add(new Imagen(28, prod.getId(), "/img/product-6.jpg"));
        imagenes.add(new Imagen(29, prod.getId(), "/img/product-6.jpg"));
        imagenes.add(new Imagen(30, prod.getId(), "/img/product-6.jpg"));
        prod.setImagenes(imagenes);
        registerProduct(prod);

        prod = new Producto(7, cat, "Medias HRX", 20000, "Medias Medio Medio", 4.5, 204);
        imagenes = new ArrayList<>();
        imagenes.add(new Imagen(31, prod.getId(), "/img/product-7.jpg"));
        imagenes.add(new Imagen(32, prod.getId(), "/img/product-7.jpg"));
        imagenes.add(new Imagen(33, prod.getId(), "/img/product-7.jpg"));
        imagenes.add(new Imagen(34, prod.getId(), "/img/product-7.jpg"));
        imagenes.add(new Imagen(35, prod.getId(), "/img/product-7.jpg"));
        prod.setImagenes(imagenes);
        registerProduct(prod);

        prod = new Producto(8, cat, "Reloj Negro Fossil", 3200000, "Ultra fino 4k el reloj", 4.0,
                5);
        imagenes = new ArrayList<>();
        imagenes.add(new Imagen(36, prod.getId(), "/img/product-8.jpg"));
        imagenes.add(new Imagen(37, prod.getId(), "/img/product-8.jpg"));
        imagenes.add(new Imagen(38, prod.getId(), "/img/product-8.jpg"));
        imagenes.add(new Imagen(39, prod.getId(), "/img/product-8.jpg"));
        imagenes.add(new Imagen(40, prod.getId(), "/img/product-8.jpg"));
        prod.setImagenes(imagenes);
        registerProduct(prod);

        prod = new Producto(9, cat, "Reloj Roadster Negro", 1203000, "Relojito aspero", 4.0, 54);
        imagenes = new ArrayList<>();
        imagenes.add(new Imagen(41, prod.getId(), "/img/product-9.jpg"));
        imagenes.add(new Imagen(42, prod.getId(), "/img/product-9.jpg"));
        imagenes.add(new Imagen(43, prod.getId(), "/img/product-9.jpg"));
        imagenes.add(new Imagen(44, prod.getId(), "/img/product-9.jpg"));
        imagenes.add(new Imagen(45, prod.getId(), "/img/product-9.jpg"));
        prod.setImagenes(imagenes);
        registerProduct(prod);

        prod = new Producto(10, cat, "Zapatillas Deportivas HRX", 200000,
                "Zapatillas negras ultra pelles", 4.5, 20);
        imagenes = new ArrayList<>();
        imagenes.add(new Imagen(46, prod.getId(), "/img/product-10.jpg"));
        imagenes.add(new Imagen(47, prod.getId(), "/img/product-10.jpg"));
        imagenes.add(new Imagen(48, prod.getId(), "/img/product-10.jpg"));
        imagenes.add(new Imagen(49, prod.getId(), "/img/product-10.jpg"));
        imagenes.add(new Imagen(50, prod.getId(), "/img/product-10.jpg"));
        prod.setImagenes(imagenes);
        registerProduct(prod);

        prod = new Producto(11, cat, "Zapatillas Grises HRX", 125999,
                "Zapatillas grises ultra pelles", 4.5, 54);
        imagenes = new ArrayList<>();
        imagenes.add(new Imagen(51, prod.getId(), "/img/product-11.jpg"));
        imagenes.add(new Imagen(52, prod.getId(), "/img/product-11.jpg"));
        imagenes.add(new Imagen(53, prod.getId(), "/img/product-11.jpg"));
        imagenes.add(new Imagen(54, prod.getId(), "/img/product-11.jpg"));
        imagenes.add(new Imagen(55, prod.getId(), "/img/product-11.jpg"));
        prod.setImagenes(imagenes);
        registerProduct(prod);

        prod = new Producto(12, cat, "Pantalon NIKE negro", 150000, "Severo Yoger", 4.0, 20);
        imagenes = new ArrayList<>();
        imagenes.add(new Imagen(56, prod.getId(), "/img/product-12.jpg"));
        imagenes.add(new Imagen(57, prod.getId(), "/img/product-12.jpg"));
        imagenes.add(new Imagen(58, prod.getId(), "/img/product-12.jpg"));
        imagenes.add(new Imagen(59, prod.getId(), "/img/product-12.jpg"));
        imagenes.add(new Imagen(60, prod.getId(), "/img/product-12.jpg"));
        prod.setImagenes(imagenes);
        registerProduct(prod);
    }

    @Override
    public List<Producto> getProductsByRating() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Producto> getProductsByLatest() {
        // TODO Auto-generated method stub
        return null;
    }
}
