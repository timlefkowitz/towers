package com.home.towers.controllers;


import com.home.towers.repos.UsersPostRepo;
import com.home.towers.repos.UsersRepository;
import com.home.towers.repos.groupRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    // Daos

    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final UsersPostRepo postsRepo;



    // Constructor

    public HomeController(UsersRepository userDao, groupRepo groupDao, UsersPostRepo postsRepo) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.postsRepo = postsRepo;
    }


    @GetMapping("/home")
    public String home(Model view)
    {
        view.addAttribute("allusers", userDao.findAll());
//        view.addAttribute("allgroups", groupDao.findAll());
        view.addAttribute("allposts", postsRepo.findAll());
        return"home";
    }


    //    Wiring in FileStack
    @Value("${FSKEY}")
    private String fileStackApi;


    // Show Constructors


}
