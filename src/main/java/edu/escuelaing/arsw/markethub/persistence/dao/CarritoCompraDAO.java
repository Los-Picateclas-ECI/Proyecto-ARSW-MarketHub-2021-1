package edu.escuelaing.arsw.markethub.persistence.dao;

import edu.escuelaing.arsw.markethub.entities.CarritoCompra;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarritoCompraDAO {

    List<CarritoCompra> getCarritoProductsByUsername(@Param("username") String username);

    void deleteProductFromCar(@Param("username") String username, @Param("producto") Integer producto);

}
