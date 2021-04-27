package edu.escuelaing.arsw.markethub.persistence.dao;

import edu.escuelaing.arsw.markethub.entities.UserMH;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMHDAO {

    UserMH getUserByUsername(@Param("usernameOrEmail") String usernameOrEmail);

    void registerUser(@Param("user") UserMH user);

    void updateUser(@Param("user") UserMH user);

    void deleteUser(@Param("username") String username);

}
