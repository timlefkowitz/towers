package com.home.towers.controllers;


import com.home.towers.models.friendslist;
import com.home.towers.models.user;
import com.home.towers.repos.UsersRepository;
import com.home.towers.repos.friendslistrepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
public class FriendsController {



//  I'm not sure if i want filestack here or not


    //    Wiring in FileStack   ///
//    @Value("${filestack.api.key}")
//    private String fileStackApi;




    //     Daos

    private UsersRepository users;
    private PasswordEncoder passwordEncoder;
    private friendslistrepo friends;



    //      Constructors
    public FriendsController(UsersRepository users, PasswordEncoder passwordEncoder, friendslistrepo friends) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.friends = friends;
    }


    //      GetMapping and Post Mapping
    @PostMapping("/friends")
    public String friendspage(@RequestParam(name = "addedUser") String addedUser)
    {


//        1. generate the user and different user types
        user userInSession = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user currentUser = users.getById(userInSession.getId());
        user addthisUser = users.getByUsername(addedUser);
//        2. generate the list of friends
        Collection<friendslist> currentUsersFriends = currentUser.getContactListOwner();
//        3. generate a new friends list
        currentUsersFriends.add(new friendslist(currentUser, addthisUser));
//        4. add friends
        currentUser.setContactListOwner(currentUsersFriends);
//        5. save the new friendslst
        users.save(currentUser);



//        {}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}
//        00.1 experiments and history
//        {}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}


//        friendslist n = new friendslist();
//        userInSession.getContactListOwner();
//        n.setOwner_user(userInSession);
//        n.setAdded_user_id(addthisUser);

        Collection<friendslist> addFriend = userInSession.getContactListOwner();
//        user addthisUserID = users.getById(addID);
//        addFriend.setOwner_user(friendslistOwner);
//        addFriend.setAdded_user_id(addthisUserID);
//        friends.save(addFriend);



        return "redirect:/friends";
    }

    @GetMapping("/friends")
    public String getFriends(Model view)
    {
//        1.generate current user as a friendslist owner
        user FRIENDSLISTOWNER = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        2. generate the current friendslist
        Collection<friendslist> friendslistGen = friends.getByOwnerUser(FRIENDSLISTOWNER);
//        I. addAttributes
        view.addAttribute("friendslist", friendslistGen);
//        II. system prints
        System.out.println(friendslistGen.size());






        return "friends";
    }




}
