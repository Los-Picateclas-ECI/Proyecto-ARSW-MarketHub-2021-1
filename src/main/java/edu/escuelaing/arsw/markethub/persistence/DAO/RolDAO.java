package edu.escuelaing.arsw.markethub.persistence.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.escuelaing.arsw.markethub.entities.Rol;

@Mapper
public interface RolDAO {

    List<Rol> getRoles();

}