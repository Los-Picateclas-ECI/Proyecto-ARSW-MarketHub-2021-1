package edu.escuelaing.arsw.markethub.services;

import java.io.File;
import java.util.List;

import edu.escuelaing.arsw.markethub.entities.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import edu.escuelaing.arsw.markethub.entities.Categoria;
import edu.escuelaing.arsw.markethub.entities.Imagen;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.persistence.Persistence;

@Service
@Component("ProductServices")
public class ProductServices {

    @Autowired
    @Qualifier("myBatisPersistence")
    Persistence persistenceMyBatis;

    @Autowired
    @Qualifier("cachePersistence")
    Persistence persistenceCache;

    /*------------------------------------*/
    /*------------ PRODUCTOS -------------*/
    /*------------------------------------*/

    public List<Producto> getAllProducts() {
        if (persistenceCache.getAllProducts().isEmpty()) {
            List<Producto> productos = persistenceMyBatis.getAllProducts();
            for (Producto producto : productos) {
                persistenceCache.registerProduct(producto);
            }
        }
        return persistenceCache.getAllProducts();
    }

    public List<Producto> getProductsByCategory(String categoryName) {
        if (persistenceCache.getProductsByCategory(categoryName).isEmpty()) {
            List<Producto> productos = persistenceMyBatis.getAllProducts();
            for (Producto producto : productos) {
                persistenceCache.registerProduct(producto);
            }
        }
        return persistenceCache.getProductsByCategory(categoryName);
    }

    public List<Producto> getProductsByRating() {
        if (persistenceCache.getProductsByRating().isEmpty()) {
            List<Producto> productos = persistenceMyBatis.getAllProducts();
            for (Producto producto : productos) {
                persistenceCache.registerProduct(producto);
            }
        }
        return persistenceCache.getProductsByRating();
    }

    public List<Producto> getProductsByLatest() {
        if (persistenceCache.getProductsByLatest().isEmpty()) {
            List<Producto> productos = persistenceMyBatis.getAllProducts();
            for (Producto producto : productos) {
                persistenceCache.registerProduct(producto);
            }
        }
        return persistenceCache.getProductsByLatest();
    }

    public Producto getProductById(Integer id) {
        if (persistenceCache.getProductById(id) == null) {
            Producto producto = persistenceMyBatis.getProductById(id);
            persistenceCache.registerProduct(producto);
        }
        return persistenceCache.getProductById(id);
    }

    public void insertProduct(Producto product) {
        persistenceMyBatis.registerProduct(product);
        persistenceCache.registerProduct(product);
    }

    /*------------------------------------*/
    /*------------ CATEGORÍAS ------------*/
    /*------------------------------------*/
    public List<Categoria> getAllCategories() {
        return persistenceMyBatis.getAllCategories();
    }

    public Categoria getCategory(String name) {
        return persistenceMyBatis.getCategory(name);
    }

    /*------------------------------------*/
    /*------------- IMÁGENES -------------*/
    /*------------------------------------*/
    public void insertImage(File image, Imagen imagenMH) {
        persistenceMyBatis.insertImage(image, imagenMH);
    }

    /*------------------------------------*/
    /*------------ COMENTARIOS -----------*/
    /*------------------------------------*/
    public List<Comentario> getAllCommentsByProductID(Integer productID) {
        if (persistenceCache.getAllCommentsByProductID(productID).isEmpty()) {
            List<Comentario> comentarioList = persistenceMyBatis.getAllCommentsByProductID(productID);
            for (Comentario comentario : comentarioList) {
                persistenceCache.registerComment(comentario);
            }
        }
        return persistenceCache.getAllCommentsByProductID(productID);
    }

    public void registerComment(Comentario comentario){
        persistenceMyBatis.registerComment(comentario);
        persistenceCache.registerComment(comentario);
    }

}
