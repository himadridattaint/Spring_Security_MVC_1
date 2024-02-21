package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class HomeController
{
    @Autowired
    private UserService userService;
    @GetMapping("/home")
    public String home()
    {
        return "home";
    }
    @GetMapping("/signin")
    public String signin()
    {
        return "signin";
    }
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user)
    {
        boolean f=userService.checkEmail(user.getEmail());
        if(f)
        {
            System.out.println("Email Already Used");
        }
        else
        {
            User user1=userService.createUser(user);
            if(user1 !=null)
            {
                System.out.println("Sign In Succesfull");
            }
            else
            {
                System.out.println("Sign In Unsuccesfull");
            }
        }

        return "signin";
    }

}
