package com.example.springWEB.service;

import com.example.springWEB.constant.ConstDefaultEntity;
import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Not find this user");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                passwordEncoder.encode(user.getPassword()),
                Collections.singletonList(new SimpleGrantedAuthority(ConstDefaultEntity.PREFIX_ROLE + user.getRole().getName())));
    }
}
