package com.thymeleaflogin.demo.com.thymeleaflogin.controller;

import com.thymeleaflogin.demo.com.thymeleaflogin.dao.UserDao;
import com.thymeleaflogin.demo.com.thymeleaflogin.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private final UserDao userDao;

    public MainController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String index(){


        return "index";
    }

    @GetMapping("/home")
    public String home(Model model){
        Iterable<User> users = userDao.findAll();

        model.addAttribute("users", users);

        return "home";

    }

    @GetMapping("/home/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model){

        User user = userDao.findById(id);

        userDao.delete(user);

        Iterable<User> users = userDao.findAll();

        model.addAttribute("users", users);

        return "home";

    }




}
