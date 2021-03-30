<<<<<<< HEAD
package edu.escuelaing.arsw.markethub.persistence.DAO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.escuelaing.arsw.markethub.entities.Categoria;

@Mapper
public interface CategoriaDAO {

    void insertCategory(@Param("cat") Categoria cat);

}
=======
package edu.escuelaing.arsw.markethub.persistence.DAO;

import edu.escuelaing.arsw.markethub.entities.Categoria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoriaDAO {

    void insertCategory(@Param("cat") Categoria cat);

    List<Categoria> getAllCategories();

}
>>>>>>> main
