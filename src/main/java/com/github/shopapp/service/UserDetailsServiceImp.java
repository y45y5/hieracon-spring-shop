package com.github.shopapp.service;

import com.github.shopapp.model.user.BasicUser;
import com.github.shopapp.model.user.BasicUserDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private BasicUserDaoImp basicUserDaoImp;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BasicUser basicUser = basicUserDaoImp.getByUsername(username);
        User.UserBuilder builder;
        if (basicUser != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(!basicUser.isEnabled());
            builder.password(basicUser.getPassword());
            List<GrantedAuthority> authorities = basicUser.getAllAuthorities();
            builder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

}
