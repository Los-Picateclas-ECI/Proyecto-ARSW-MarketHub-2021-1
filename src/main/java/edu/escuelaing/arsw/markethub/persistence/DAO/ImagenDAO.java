package edu.escuelaing.arsw.markethub.persistence.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.escuelaing.arsw.markethub.entities.Imagen;

@Mapper
public interface ImagenDAO {

    void insertImage(@Param("img") Imagen img);

}
