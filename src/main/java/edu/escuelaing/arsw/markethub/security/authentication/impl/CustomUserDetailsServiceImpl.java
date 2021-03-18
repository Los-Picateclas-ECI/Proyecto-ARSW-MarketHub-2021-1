package edu.escuelaing.arsw.markethub.security.authentication.impl;

import edu.escuelaing.arsw.markethub.entities.UserMH;
import edu.escuelaing.arsw.markethub.security.authentication.CustomUserDetailsService;
import edu.escuelaing.arsw.markethub.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("CustomUserDetailsServiceImpl")
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServices accountServices;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserMH user = accountServices.getUser(s);
        if (user != null) {
            return User.withUsername(s).password(passwordEncoder.encode(user.getPassword())).roles(user.getRole()).build();
        }
        throw new UsernameNotFoundException(s);
    }

}
