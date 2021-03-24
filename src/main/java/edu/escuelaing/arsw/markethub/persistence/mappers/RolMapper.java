package edu.escuelaing.arsw.markethub.persistence.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.escuelaing.arsw.markethub.entities.Rol;

@Mapper
public interface RolMapper {

    List<Rol> getRoles();

}
