package edu.escuelaing.arsw.markethub.persistence.impl;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import edu.escuelaing.arsw.markethub.entities.CarritoCompra;
import edu.escuelaing.arsw.markethub.entities.Categoria;
import edu.escuelaing.arsw.markethub.entities.Comentario;
import edu.escuelaing.arsw.markethub.entities.Imagen;
import edu.escuelaing.arsw.markethub.entities.Producto;
import edu.escuelaing.arsw.markethub.entities.Rol;
import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.Persistence;
import edu.escuelaing.arsw.markethub.persistence.dao.CarritoCompraDAO;
import edu.escuelaing.arsw.markethub.persistence.dao.CategoriaDAO;
import edu.escuelaing.arsw.markethub.persistence.dao.ComentarioDAO;
import edu.escuelaing.arsw.markethub.persistence.dao.ImagenDAO;
import edu.escuelaing.arsw.markethub.persistence.dao.ProductoDAO;
import edu.escuelaing.arsw.markethub.persistence.dao.RolDAO;
import edu.escuelaing.arsw.markethub.persistence.dao.UserMHDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myBatisPersistence")
public class MyBatisPersistence implements Persistence {

	UserMHDAO userMHDAO;

	ProductoDAO productoDAO;

	CategoriaDAO categoriaDAO;

	ImagenDAO imagenDAO;

	RolDAO rolDAO;

	ComentarioDAO comentarioDAO;

	CarritoCompraDAO carritoCompraDAO;

	@Autowired
	public MyBatisPersistence(final UserMHDAO userMHDAO, final ProductoDAO productoDAO,
							  final CategoriaDAO categoriaDAO, final ImagenDAO imagenDAO, final RolDAO rolDAO,
							  final ComentarioDAO comentarioDAO, final CarritoCompraDAO carritoCompraDAO) {

		this.userMHDAO = userMHDAO;
		this.productoDAO = productoDAO;
		this.categoriaDAO = categoriaDAO;
		this.imagenDAO = imagenDAO;
		this.rolDAO = rolDAO;
		this.comentarioDAO = comentarioDAO;
		this.carritoCompraDAO = carritoCompraDAO;
	}

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

	@Override
	public void updateUser(UserMH user) {

		userMHDAO.updateUser(user);
	}

	@Override
	public void deleteUser(String username) {

		userMHDAO.deleteUser(username);
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
	public void updateProductInformation(Producto producto) {

		productoDAO.updateProductInformation(producto);
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

	@Override
	public void updateExistencias(Integer cantidad, Integer productoID) {

		productoDAO.updateExistencias(cantidad, productoID);
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

	@Override
	public void deleteAllFromCar(String username) {

		carritoCompraDAO.deleteAllFromCar(username);
	}

}
