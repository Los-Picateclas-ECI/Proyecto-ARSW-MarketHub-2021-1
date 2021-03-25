package edu.escuelaing.arsw.markethub.persistence.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.escuelaing.arsw.markethub.entities.Producto;

@Mapper
public interface ProductoDAO {

    void insertProduct(@Param("prod") Producto prod);

}
