package com.home.towers.controllers;


import com.home.towers.models.*;
import com.home.towers.repos.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class CreateControllers {

    // instances

    private final UsersRepository usersDao;
    private final UsersPostRepo usersPost;
    private final groupRepo groupDao;
    private final PasswordEncoder passwordEncoder;
    private final friendslistrepo friendslistrepoDao;
    private final tokenRepo tokenRepoDao;
    private final statusRepo statusDao;


//    Wiring in FileStack
    @Value("${FSKEY}")
    private String fileStackApi;


    // constructors


    public CreateControllers(UsersRepository usersDao, UsersPostRepo usersPost, groupRepo groupDao, groupPostRepo groupPostDao, PasswordEncoder passwordEncoder, friendslistrepo friendslistrepoDao, tokenRepo tokenRepoDao, statusRepo statusDao) {
        this.usersDao = usersDao;
        this.usersPost = usersPost;
        this.groupDao = groupDao;
        this.passwordEncoder = passwordEncoder;
        this.friendslistrepoDao = friendslistrepoDao;
        this.tokenRepoDao = tokenRepoDao;
        this.statusDao = statusDao;
    }


    // User Sign Up

    @GetMapping("users/sign-up")
    public String Signup(Model model)
    {
        model.addAttribute("user", new user());
        model.addAttribute("fileStackApi", fileStackApi);
        return"users/sign-up";
    }

    @PostMapping("users/sign-up")
    public String addANewUser(@RequestParam(name="username") String username,
                               @RequestParam(name="email") String email,
                              @RequestParam(name="password") String password,
                              @RequestParam(name="firstname") String firstname,
                              @RequestParam(name="middleName") String middlename,
                              @RequestParam(name="lastName") String lastName,
                              @RequestParam(name="mobile") long mobilenumber,
                              @RequestParam(name="status") String status,
                              @RequestParam(name="profile") String profile,
                              @RequestParam(name="imgPath") String imgPath,
                              @RequestParam(name="originalavatar") String originalavatar


    ){


//        we are creating a new user
        user n = new user();

        user firstFriend = usersDao.getById(7l);
        friendslist i = new friendslist();
        i.setAdded_user_id(firstFriend);
        friendslistrepoDao.save(i);



        String hash = passwordEncoder.encode(password);


//        String hashedPost = passwordEncoder.encode(UsersPost)


//        4. lets set all our requested Parameters
        n.setPassword(hash);
        n.setUsername(username);
        n.setEmail(email);
        n.setFirstname(firstname);
        n.setMiddleName(middlename);
        n.setLastName(lastName);
        n.setMobile(mobilenumber);
        n.setStatus(status);
        n.setProfile(profile);


        System.out.println(imgPath);


//        {}{}{}{} PHOTONS {}{}{}{}{}{}{}{}{}{}{}{}{}

//        Creating a empty collection. We are wanting to do this so the collection exist
        Token hp = new Token();
//            save the collection to the repo
        String first = "First NFT";
//        hashPostRepo.save(first);

        if (imgPath == ""){
            imgPath = originalavatar;

            System.out.println(imgPath + " ###");
//            originalavatar = imgPath;
        }

//        4. lets set all our requested Parameters
        n.setImgPath(imgPath);
        n.setOriginalavatar(originalavatar);

        usersDao.save(n);
        return "redirect:/home";
    }


    // Create a Users Post

    @GetMapping("/post")
    public String usersPost(Model model)
    {
        model.addAttribute("usersPost", new usersPost());
        model.addAttribute("fileStackApi",fileStackApi);
        return"UserPostingForm";
    }

    @PostMapping("/post")
    public String addAnewUserPost(@RequestParam(name="title") String title,
                                  @RequestParam(name="body") String description,
                                  @RequestParam(name="imgPath") String imgPath
//                                  @RequestParam(name="postOwner") user postOwner


    ){
//        1. lets get the current user
        user user = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        2. get the currentUsers username
        user username = usersDao.getByUsername(user.username);

//        Collection <HashedPostRepo> hashedPostRepoCollection = user.getHashedPostModelOwner(groupOwnersUsersName);
//        3. lets create a new userspost


        usersPost n = new usersPost();

//        4. lets set all our requested Parameters
        n.setImgPath(imgPath);
        n.setOwner(user);
        n.setTitle(title);
        n.setBody(description);
        usersPost.save(n);

        Collection<Token> tokens = user.getReceivedTokens();
        String PostToString = n.toString();
        String hash = passwordEncoder.encode(PostToString);

        Token x = new Token();
        x.setTokenOwner(username);
        x.setHashedPostFinalString(hash);
        tokenRepoDao.save(x);





//        hashPostRepo.save(hashedPostRepoCollection);

        return "redirect:/home";
    }

    // Create a Group

    @GetMapping("/groupcreation")
    public String createAgroup(Model model)
    {
        model.addAttribute("fileStackApi", fileStackApi);
        return"CreateAGroup";
    }


    @PostMapping("/groupcreation")
    public String addAnewGroup(@RequestParam(name="GroupPosttitle") String title,
                               @RequestParam(name="GroupPostsummary") String summary
//                               @RequestParam(name="GroupPostcreatedBy") String createdBy,
//                               @RequestParam(name="GroupPostcontent") String content,
//                               @RequestParam(name="GroupPostIMGPath") String GroupPostIMGPath


    ){


        user currentUser = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        groups n = new groups();
        n.setSummary(summary);
        n.setTitle(title);
//        n.setContent(content);
//        n.setCreatedBy(createdBy);
        n.setGroupOwner(currentUser);
//        save the groups info
        groupDao.save(n);
        return "redirect:/home";
    }


    // status update


    @GetMapping("/updatestatus")
    public String status(Model model)
    {
        return"statusupdate";
    }

    @PostMapping("/updatestatus")
    public String statusUpdate(Model view,
                               @RequestParam(name="status") String status
    ){

        user currentUser = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        status n = new status();
        n.setStatus(status);
        n.setStatusOwner(currentUser);
        statusDao.save(n);

        return "redirect:/home";
    }


}
