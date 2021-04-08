package edu.escuelaing.arsw.markethub.persistence.dao;

import edu.escuelaing.arsw.markethub.entities.UserMH;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMHDAO {

    UserMH getUserByUsername(@Param("usernameOrEmail") String usernameOrEmail);

}
