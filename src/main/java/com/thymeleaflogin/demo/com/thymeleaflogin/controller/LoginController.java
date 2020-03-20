package com.thymeleaflogin.demo.com.thymeleaflogin.controller;

import com.thymeleaflogin.demo.com.thymeleaflogin.dao.UserDao;
import com.thymeleaflogin.demo.com.thymeleaflogin.form.LoginForm;
import com.thymeleaflogin.demo.com.thymeleaflogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm() {


        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {

        List<User> users = userDao.findAll();

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        for (User userFromDb : users) {

            if (userFromDb.getUsername().equals(username) && userFromDb.getPassword().equals(password)) {
                return "redirect:/home";
            }


//            if ("admin".equals(username) && "admin".equals(password)) {
//
//                return "redirect:/home";
//            }

        }

        model.addAttribute("invalidCredentials", true);

        return "login";
    }
}
