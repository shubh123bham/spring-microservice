package com.springboot.microservice.dao;

import com.springboot.microservice.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    EntityManager entityManager;



    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findUserByEmail(String email) {
        System.out.println("findUser by email "+ email);
        String jpql = "SELECT u FROM User u WHERE u.email = :email";
        return entityManager.createQuery(jpql, User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<User> allUsers() {
        String jpql = "SELECT u FROM User u";
        return entityManager.createQuery(jpql,User.class).getResultList();
    }
}
