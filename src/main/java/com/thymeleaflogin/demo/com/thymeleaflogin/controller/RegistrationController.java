package com.thymeleaflogin.demo.com.thymeleaflogin.controller;

import com.thymeleaflogin.demo.com.thymeleaflogin.dao.UserDao;
import com.thymeleaflogin.demo.com.thymeleaflogin.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    final UserDao userDao;

    public RegistrationController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/registration")
    public String getRegistrationForm() {

        return "registration";
    }

    @PostMapping(value = "/registration")
    public String register(User user){

        userDao.save(user);

        return "redirect:/home";
    }
}
