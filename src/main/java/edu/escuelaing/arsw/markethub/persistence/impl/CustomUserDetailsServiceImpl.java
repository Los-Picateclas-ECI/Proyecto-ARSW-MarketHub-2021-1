package edu.escuelaing.arsw.markethub.persistence.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.persistence.CustomUserDetailsService;

@Component("CustomUserDetailsServiceImpl")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public MockPersistence mockPersistence;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserMH user = s.contains("@") ? mockPersistence.getUserByEmail(s) : mockPersistence.getUserByUsername(s);
        if (user != null) {
            return User.withUsername(s).password(passwordEncoder.encode(user.getPassword())).roles(user.getRole()).build();
        }
        throw new UsernameNotFoundException(s);
    }

}
