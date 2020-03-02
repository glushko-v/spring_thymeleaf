package com.thymeleaflogin.demo.com.thymeleaflogin.dao;

import com.thymeleaflogin.demo.com.thymeleaflogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findById(long id);
}