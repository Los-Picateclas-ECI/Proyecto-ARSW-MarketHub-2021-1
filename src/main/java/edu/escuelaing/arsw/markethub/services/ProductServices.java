package edu.escuelaing.arsw.markethub.services;

import java.io.File;
import java.util.List;

import edu.escuelaing.arsw.markethub.entities.CarritoCompra;
import edu.escuelaing.arsw.markethub.entities.Categoria;
import edu.escuelaing.arsw.markethub.entities.Comentario;
import edu.escuelaing.arsw.markethub.entities.Imagen;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("ProductServices")
public class ProductServices {

	Persistence persistenceMyBatis;

	Persistence persistenceCache;

	@Autowired
	public ProductServices(@Qualifier("myBatisPersistence") final Persistence persistenceMyBatis,
						   @Qualifier("cachePersistence") final Persistence persistenceCache) {

		this.persistenceMyBatis = persistenceMyBatis;
		this.persistenceCache = persistenceCache;
	}

	/*------------------------------------*/
	/*------------ PRODUCTOS -------------*/
	/*------------------------------------*/

	public void updateProductInformation(Producto producto) {

		persistenceMyBatis.updateProductInformation(producto);
		persistenceCache.updateProductInformation(producto);
	}

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
	}

	public void insertProductCache(Producto producto) {

		persistenceCache.registerProduct(persistenceMyBatis.getProductById(producto.getId()));
	}

	public void updateExistencias(Integer cantidad, Integer productoID) {

		persistenceMyBatis.updateExistencias(cantidad, productoID);
		persistenceCache.updateExistencias(cantidad, productoID);
	}

	public void updateExistenciasWithCarInfo(String username) {

		List<CarritoCompra> carritoCompraList = this.getCarritoProductsByUsername(username);
		for (CarritoCompra carritoCompra : carritoCompraList) {
			this.updateExistencias(carritoCompra.getCantidad(), carritoCompra.getProducto().getId());
		}
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

	public void registerComment(Comentario comentario) {

		persistenceMyBatis.registerComment(comentario);
		persistenceCache.registerComment(comentario);
	}

	/*------------------------------------*/
	/*---------- CARRITO COMPRA ----------*/
	/*------------------------------------*/

	public List<CarritoCompra> getCarritoProductsByUsername(String username) {

		return persistenceMyBatis.getCarritoProductsByUsername(username);
	}

	public void deleteProductFromCar(Integer productID) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = ((User) auth.getPrincipal()).getUsername();
		persistenceMyBatis.deleteProductFromCar(username, productID);
	}

	public void insertCarritoCompra(CarritoCompra carrito) {

		try {
			persistenceMyBatis.insertCarritoCompra(carrito);
		} catch (DuplicateKeyException e) {
			persistenceMyBatis.updateCantidad(carrito);
		}
	}

	public void deleteAllFromCar(String username) {

		persistenceMyBatis.deleteAllFromCar(username);
	}

}
