package edu.escuelaing.arsw.markethub.persistence.dao;

import edu.escuelaing.arsw.markethub.entities.Comentario;
import edu.escuelaing.arsw.markethub.entities.Producto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComentarioDAO {

    Integer insertComment(@Param("com") Comentario com);

    List<Comentario> getAllCommentsByProductID(@Param("producto") Integer producto);

}
