package edu.escuelaing.arsw.markethub.persistence.dao;

import java.util.List;

import edu.escuelaing.arsw.markethub.entities.Producto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductoDAO {

	void insertProduct(@Param("prod") Producto prod);

	List<Producto> getAllProducts();

	List<Producto> getProductsByCategory(@Param("categoryName") String categoryName);

	List<Producto> getProductsByRating();

	List<Producto> getProductsByLatest();

	Producto getProductById(@Param("id") int id);

	void updateExistencias(@Param("cantidad") Integer cantidad, @Param("producto") Integer producto);

	void updateProductInformation(@Param("producto") Producto producto);
}
