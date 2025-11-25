package com.home.towers.controllers;


import com.home.towers.models.friendslist;
import com.home.towers.models.user;
import com.home.towers.repos.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class CustomController {

    // Daos

    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final UsersPostRepo postsRepo;
    private final friendslistrepo friendslistDao;
    private final statusRepo statusDao;


    public CustomController(UsersRepository userDao, groupRepo groupDao, UsersPostRepo postsRepo, friendslistrepo friendslistDao, statusRepo statusDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.postsRepo = postsRepo;
        this.friendslistDao = friendslistDao;
        this.statusDao = statusDao;
    }



    @GetMapping("/Tim")
    public String tim(
            Model view

    ){


        user userOfCurrentProfile = userDao.getByUsername("Tim");
        Collection<friendslist> friendslistGen = friendslistDao.getByOwnerUser(userOfCurrentProfile);
//        Collection<UsersPostRepo> myPostlistGen = postsRepo.getByPostOwner(userOfCurrentProfile);

        view.addAttribute("user", userDao.getById(1l));
        view.addAttribute("FriendsListRepo", friendslistGen);
//        view.addAttribute("MyPostGenerator", myPostlistGen);

        return "Tim";
    }

    @GetMapping("/helptank")
    public String helptank(
    ){
        return "helptank";
    }

    //      GetMapping and Post Mapping
//    @PostMapping("/friends")
//    public String friendspage(@RequestParam(name = "addedUser") String addedUser)
//    {
//
//
////        1. generate the user and different user types
//        user userInSession = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        user currentUser = userDao.getById(userInSession.getId());
//        user addthisUser = userDao.getByUsername(addedUser);
////        2. generate the list of friends
//        Collection<friendslist> currentUsersFriends = currentUser.getContactListOwner();
////        3. generate a new friends list
//        currentUsersFriends.add(new friendslist(currentUser, addthisUser));
////        4. add friends
//        currentUser.setContactListOwner(currentUsersFriends);
////        5. save the new friendslst
//        userDao.save(currentUser);
//
//
//        return "redirect:/friends";
//    }


//    old project imports

    @GetMapping("/Tim/calc")
    public String calc(
    ){
        return "import/calc";
    }
    @GetMapping("/Tim/coffee")
    public String coffee(
    ){
        return "import/coffee";
    }
    @GetMapping("/Tim/foods")
    public String foods(
    ){
        return "import/foods";
    }
    @GetMapping("/Tim/konami")
    public String konami(
    ){
        return "import/konami";
    }
    @GetMapping("/Tim/weathermap")
    public String weather(
    ){
        return "import/weathermap";
    }

//            art

    @GetMapping("/Tim/flicks")
    public String flicks(
    ){
        return "import/flickarchive";
    }
    @GetMapping("/Tim/three")
    public String three(
    ){
        return "import/3d";
    }

//            resume and cv
    @GetMapping("/Tim/contact")
    public String cv(
    ){
        return "import/contact";
    }

}
