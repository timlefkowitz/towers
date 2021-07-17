package com.home.facebookclone.controllers;


import com.home.facebookclone.repos.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    // I need to throw some catch statements into this capstone
//           if(HomeController = null ){
//        throw new IllegalArgumentException();
//    }


    // Repo Daos

    private final UsersRepository userDao;

    public HomeController(UsersRepository userDao) {
        this.userDao = userDao;
    }


    @GetMapping("/")
    public String landingPage()
    {
        return"index";
    }

    @GetMapping("/admin")
    public String adminHome(Model view)
    {
        view.addAttribute("allusers", userDao.findAll());
        return"admin/AdminsHome";
    }


    // HOME PAGE

    @GetMapping("/UsersHome")
    public String usersHome()
    {
        return"UsersHome";
    }

    @GetMapping("/UsersHome/{id}")
    public String showById(@PathVariable Long id, Model view){
        view.addAttribute("ads", userDao.getById(id));
        return "UsersHome";
    }


    @GetMapping("/UsersProfile")
    public String usersProfile()
    {
        return"UsersProfile";
    }

    // Currently Signed in profile
    @GetMapping("/currentProfile")
    public String currentUsersProfile()
    {
        return"CurrentUsersProfileAndEditProfile";
    }







}
