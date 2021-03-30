package edu.escuelaing.arsw.markethub.persistence.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.escuelaing.arsw.markethub.entities.Producto;

@Mapper
public interface ProductoDAO {

    List<Producto> getAllProducts();

    Producto getProductById(@Param("id") int id);

    void insertProduct(@Param("prod") Producto prod);

}
