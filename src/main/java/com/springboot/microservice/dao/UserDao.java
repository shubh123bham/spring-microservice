package com.springboot.microservice.dao;

import com.springboot.microservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao{
    public void save(User user);
}
