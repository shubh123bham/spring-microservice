package com.springboot.microservice.controller;

import com.springboot.microservice.dao.UserDao;
import com.springboot.microservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("title","smart contact manager");
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userObject",new User());
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String registerPost(@ModelAttribute("userObject") User user){
        System.out.println("user user name "+ user.getName());
        userDao.save(user);
        return "Done";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
