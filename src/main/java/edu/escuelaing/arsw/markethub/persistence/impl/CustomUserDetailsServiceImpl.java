package edu.escuelaing.arsw.markethub.persistence.impl;

import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.CustomUserDetailsService;
import edu.escuelaing.arsw.markethub.persistence.impl.MockPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("CustomUserDetailsServiceImpl")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public MockPersistence mockPersistence;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<UserMH> userList = mockPersistence.getAllUsers();
        List<UserDetails> userDetailsList = new ArrayList<>();
        for (UserMH user : userList){
            if (user.getUsername().equals(s)){
                return User.withUsername(s).password(passwordEncoder.encode(user.getPassword())).roles("USER").build();
            }
        }
        throw new UsernameNotFoundException(s);
    }

}
