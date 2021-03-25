package edu.escuelaing.arsw.markethub.persistence.DAO;

import edu.escuelaing.arsw.markethub.entities.UserMH;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMHDAO {

    UserMH getUserByUsername(@Param("username") String username);

}
