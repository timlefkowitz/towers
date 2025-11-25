package com.home.towers.controllers;

import com.home.towers.models.groups;
import com.home.towers.models.user;
import com.home.towers.repos.UsersPostRepo;
import com.home.towers.repos.UsersRepository;
import com.home.towers.repos.groupRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {


    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final UsersPostRepo postsRepo;



    //    Wiring in FileStack
    @Value("${FSKEY}")
    private String fileStackApi;



    @GetMapping("/")
    public String landingPage(Model view)
    {

        view.addAttribute("allusers", userDao.findAll());
        view.addAttribute("allgroups", groupDao.findAll());
        view.addAttribute("allpost", postsRepo.findAll());
        return"index";
    }

    @GetMapping("/index")
    public String login()
    {
        return"index";
    }



    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }


    public AuthenticationController(UsersRepository userDao, groupRepo groupDao, UsersPostRepo postsRepo) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.postsRepo = postsRepo;
    }

    @GetMapping("/secret")
    public String secret(Model view) {


        return "users/secret";
    }

    @PostMapping("/secret")
    public String selectedUpload(@RequestParam(name="newAvatar") String newAvatar){

            user currentUser = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            currentUser.setImgPath(newAvatar);
            userDao.save(currentUser);
//
//            groups n = new groups();
//
//            n.setGroupOwner(currentUser);
//
//            groupDao.save(n); @RequestParam(name="GroupPostIMGPath") String GroupPostIMGPath

        return"redirect:/home";
    }

    @GetMapping("/gifs")
    public String gifs(Model view) {


        return "users/avatars";
    }




//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "users/login";
//    }


//    @GetMapping("/admin")
//    public String adminHome(Model view)
//    {
//        view.addAttribute("allusers", userDao.findAll());
//        view.addAttribute("allgroups", groupDao.findAll());
//        return"admin/AdminsHome";
//    }








}