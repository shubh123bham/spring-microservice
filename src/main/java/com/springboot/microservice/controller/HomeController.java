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
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String registerPost(@RequestParam String username, String password, String email){
        User user = new User();
        user.setName(username);
        user.setEmail(email);
        user.setPassword(password);
        userDao.save(user);
        return "Done";
    }

}
