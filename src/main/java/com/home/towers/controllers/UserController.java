package com.home.towers.controllers;

import com.home.towers.models.friendslist;
import com.home.towers.models.user;
import com.home.towers.repos.UsersRepository;
import com.home.towers.repos.friendslistrepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class UserController {

//        Daos

    private UsersRepository users;
    private PasswordEncoder passwordEncoder;
    private friendslistrepo friends;

//        Constructor
    public UserController(UsersRepository users, PasswordEncoder passwordEncoder, friendslistrepo friends) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.friends = friends;
    }


    //    Wiring in FileStack
    @Value("${FSKEY}")
    private String fileStackApi;


//        Sign Up


    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new user());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute user user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/home";
    }

}
