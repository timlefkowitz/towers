package com.home.towers.controllers;


import com.home.towers.models.friendslist;
import com.home.towers.models.user;
import com.home.towers.models.usersPost;
import com.home.towers.repos.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Controller
public class ProfileController {

    // Daos

    private final UsersRepository userDao;
    private final groupRepo groupDao;
    private final UsersPostRepo postsRepo;
    private final friendslistrepo friendslistDao;
    private final statusRepo statusDao;
    private final GroupMembersRepo groupMembersRepo;



//    @GetMapping("/{username}/{id}")
//    public String showById2(@PathVariable Long id, Model view, String username){
//        view.addAttribute("user", userDao.getById(id));
//        view.addAttribute("username", userDao.getByUsername(username));
//        view.addAttribute("usersPost", postsRepo.getById(id));
//        view.addAttribute("{id}+friends", userDao.getById(id));
////        view.addAttribute("status", statusDao.getByUsername(username));
//        return "UsersProfile";
//    }

    @GetMapping("/i/{username}")
    public String showByUsername(@PathVariable String username,
                                 Model view
//                                 @RequestParam(name="addfriend") long addID
    ){

        //adding featured post. Lets make featuredPost.length, then random number between the length of all post.
        // then use math random to select one of the post

//        long featuredPost = (long) ( Math.random() * 2 + 1);


//        lets grab the friendslist by username

//        1. convert user to the username
        user currentUser = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user currentProfile = userDao.getByUsername(username);


//        2. lets generate the current friendslist
//        2.1 we need to covert username of the path variable to
        user userOfCurrentProfile = userDao.getByUsername(username);
        String usernameOfCurrentUser = currentUser.username;
        Collection<friendslist> friendslistGen = friendslistDao.getByOwnerUser(userOfCurrentProfile);

//          3. we want to see if the current user is friends with the usersProfile
        Boolean verifiedFriend = friendslistGen.contains(usernameOfCurrentUser);
//
//        Collection<String> notVerified = new ArrayList<>();
//        notVerified.add("Sorry, Must be friends to view friends");
//
//
//        if(friendslistGen.contains(usernameOfCurrentUser) == true){
//            return friendslistGen;
//        } else if(verifiedFriend == false){
//            return notVerified;
//        }

//        0.001 add Attributes
        view.addAttribute("user", userDao.getByUsername(username));
        view.addAttribute("FriendsListRepo", friendslistGen);
        view.addAttribute("allusers", userDao.findAll());
        view.addAttribute("memberList", groupMembersRepo.getByGroupMember_Id(currentUser.getId()));



        System.out.println("This is group members");
        System.out.println("This is group members" + groupMembersRepo.getByGroupMember_Id(currentUser.getId()));


        List<usersPost> featured = new ArrayList<>();
//        featured.add(postsRepo.findAll());

        System.out.println(postsRepo.findAll() +"dsadasdadsadada");
        view.addAttribute("featuredPost", postsRepo.findAll());
//        view.addAttribute("groups", groupDao.getByGroupMember())
//        view.addAttribute("status", statusDao.getByUsername(currentUser));

//        view.addAttribute("featuredPost", userDao.getByUsername(username).getBlogPost());
//        view.addAttribute("featuredPost", postsRepo.findByOwner(currentProfile));

//        view.addAttribute("featuredPost", postsRepo.findAllByUsername(username));
//        user featuredPostOwner = userDao.getByUsername(username);
//        view.addAttribute("theFeaturedPost", postsRepo.findByOwner(featuredPostOwner));
//        view.addAttribute("addfriend", addID);
        return "UsersProfile";
    }



    @PostMapping("/i/{username}")
    public String profilePostings(@RequestParam(name="FriendHidden") long addID){

//        Creating a new friends list query
//        1. we are creating a new friendslist
        friendslist addedFriend = new friendslist();

//        2. creating the variable to add by users ID
        user addedUser = userDao.getById(addID);

//        3. this tells us who the current user is
        user friendslistOwner = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        long newfriend = addedUser.getId();

//        String usernameString = {username};

        addedFriend.setOwner_user(friendslistOwner);
        addedFriend.setAdded_user_id(addedUser);
        friendslistDao.save(addedFriend);


        return "redirect:/home";
    }






    boolean isProfileOwner;

//       Edit Profile
    @GetMapping("/{username}/edit")
    public String editProfile(@PathVariable String username, Model view){


        user userInSession = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
        user currentUser = userDao.getByUsername(userInSession.username);
        user profileOwner = userDao.getByUsername(username);

        view.addAttribute("isProfileOwner", isProfileOwner);

//        System.out.println(currentUser);
        System.out.println("profileowner" + profileOwner.username);
        System.out.println("currentUSer" + userInSession.username);

        if(userInSession == profileOwner){
            System.out.println("You are not the profile owner");
            isProfileOwner = true;
        } else {
            System.out.println("You are the profile Owner");
            isProfileOwner = false;
        }

        System.out.println(isProfileOwner);


        //        0.001 add Attributes
        view.addAttribute("userToEdit", userDao.getByUsername(username));
        view.addAttribute("allusers", userDao.findAll());
        view.addAttribute("featuredPost", postsRepo.findAll().size() -1);



        return "editprofile";
    }

    @PostMapping("/{username}/edit")
    public String editProfile(@PathVariable String username,
                              @RequestParam(name="statusToUpdate") String statusToUpdate, Model view
    ){
        //        currentUser should === username; if true show page

//        lets get the current user
        user currentUser = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        lets grab current users username
        String currentUsersUsername = currentUser.username;
//        lets make a boolean for if the user matches the user profile they want to edit
        boolean DoesUsernameMatchCurrentuser = false;

        user n = currentUser;
        n.setStatus(statusToUpdate);

//
//                contains(usernameOfCurrentUser);
//
//        String currentStatus = currentUser.setStatus(updateStatus);
//        String updateStatus = statusToUpdate;
//
        userDao.save(n);
        view.addAttribute("userToEdit", userDao.getByUsername(username));


        return "redirect:/home";
    }




//    @RequestMapping(value="/myprofile")
//    public String myprofile(@PathVariable Long id, Model view, String username, String status, Principal principal){
//        view.addAttribute("myprofile", userDao.getById(id));
//        view.addAttribute("mygroups", groupDao.getById(id));
//        view.addAttribute("username", userDao.getByUsername(username));
//        view.addAttribute("usersPost", postsRepo.getById(id));
//        view.addAttribute("{id}+friends", userDao.getById(id));
//        view.addAttribute("myfriends", friendslistDao.getById(id));
//
//        String n = principal.getName();
//        view.addAttribute("myprofile", userDao.findByUsername(n));
//
//
//
//
//        return "myprofile";
//    }

    @GetMapping("/show/{id}")
    public String showById(@PathVariable long id,Model view){
        view.addAttribute("singlePost", postsRepo.getById(id));
        return"singlePost";
    }




//    @PostMapping("show/{id}/delete")
//    public String deleteUsersPost(@PathVariable Long id)
//    {
//        Order order = orderDao.getById(id);
//        orderDao.delete(order);
//        return "redirect:/show";
//    }


    public ProfileController(UsersRepository userDao, groupRepo groupDao, UsersPostRepo postsRepo, friendslistrepo friendslistDao, statusRepo statusDao, GroupMembersRepo groupMembersRepo) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.postsRepo = postsRepo;
        this.friendslistDao = friendslistDao;
        this.statusDao = statusDao;
        this.groupMembersRepo = groupMembersRepo;
    }
}
