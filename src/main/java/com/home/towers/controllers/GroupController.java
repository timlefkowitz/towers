package com.home.towers.controllers;


/*
        group controller
        tue Aug 3 2021

 */

import com.home.towers.models.*;
import com.home.towers.repos.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
public class GroupController {

    // Daos

    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final groupPostRepo groupPostDao;
    private final UsersPostRepo postsDao;
    private final GroupMembersRepo groupMemberDao;



    //    Wiring in FileStack
    @Value("${FSKEY}")
    private String fileStackApi;



    // Blank


    public GroupController(UsersRepository userDao, groupRepo groupDao, groupPostRepo groupPostDao, UsersPostRepo postsDao, GroupMembersRepo groupMemberDao) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.groupPostDao = groupPostDao;
        this.postsDao = postsDao;
        this.groupMemberDao = groupMemberDao;
    }

    @GetMapping("/groups")
    public String groupsHomeView(Model view)
    {
////        1. addAttributes
//        view.addAttribute("allgroups", groupslistGenerator);
        view.addAttribute("allgroups", groupDao.findAll());

//        {}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}
//        00.1 experiments and history

//        System Prints
//        System.out.println(groupMember);
        return "groups";
    }

    @GetMapping("groups/{title}")
    public String showGroupByTitle(@PathVariable String title,
                                 Model view
    ){
//            Current user and their username
        user currentUser = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String usernameOfCurrentUser = currentUser.username;

//            Current Group
//        groups currentGroup = groupDao.getByTitle(title);

//        0.001 add Attributes
        view.addAttribute("groupProfile", groupDao.getByTitle(title));


        return "groupHome";
    }



    //      GetMapping and Post Mapping
    @PostMapping("/groups/{title}")
    public String friendspage(@PathVariable String title,
            @RequestParam(name = "addedUser") String addedUser

    ){


//        1. generate the user and different user types
        user userInSession = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user currentUser = userDao.getById(userInSession.getId());
        user addthisUser = userDao.getByUsername(addedUser);

//            get group by title
        groups currentGroup = groupDao.getByTitle(title);
//            generate the current collection users groups
//        Collection<groupMember> currentGroupMembers = currentGroup.getGroupMember();
        groupMember memberToAdd = new groupMember(currentGroup, currentUser);

        groupMemberDao.save(memberToAdd);

//        currentGroupMembers.add(new groupMember());
//        Collection<groups> currentUsersGroups = currentUser.getGroupMember();
//
//        currentUsersGroups.add(new groups(currentGroup, addthisUser));
////        4. add friends
//        currentUser.setGroupMember(currentUsersGroups);
////        5. save the new friendslst
//        groupDao.save(currentGroup);


        return "redirect:/groups";
    }









    // Create a Group Post

    @GetMapping("/PostToAGroup/{title}")
    public String postToAGroup(@PathVariable String title, Model model)
    {
        model.addAttribute("fileStackApi",fileStackApi);
        model.addAttribute("groupId", groupDao.findAll());  // When I come back to this we can link all groupsThatBelongToOwner
//        model.addAttribute("group", groupDao.getByTitle(title));
        model.addAttribute("allgroups", groupDao.findAll());
        return"GroupPostingForm";
    }

    @PostMapping("/PostToAGroup/{title}")
    public String addAnewGroupPost(@RequestParam(name="GroupPostsummary") String summary,
                                   @RequestParam(name="GroupPostcreatedBy") String createdBy,
                                   @RequestParam(name="GroupPostcontent") String content,
                                   @RequestParam(name="GroupPostIMGPath") String GroupPostIMGPath,
                                   @PathVariable(name="title") String title

    ){

        //            Current user and their username
        user currentUser = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String usernameOfCurrentUser = currentUser.username;




        return "redirect:/home";


        //        groupPost n = new groupPost();
//        groupPostDao.save(n);
    }



}
