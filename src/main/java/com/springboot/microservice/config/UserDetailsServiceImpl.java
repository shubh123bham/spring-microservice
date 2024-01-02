package com.springboot.microservice.config;

import com.springboot.microservice.dao.UserDao;
import com.springboot.microservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("coming here");
        User user = userDao.findUserByEmail(email);
        if(user==null){
            System.out.println("User not found");
            return null;
        }
        UserDetails userDetails = new UserDetailsImpl(user);
        return userDetails;
    }
}
