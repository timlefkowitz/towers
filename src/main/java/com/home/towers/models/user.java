package com.home.towers.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity // << this is how hibernate knows to make tables out of the class
@Table(name="user")
public class  user {





    // [][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] the Blank function              [][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]


    public user(){

    }




    // [][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] Calling instances               [][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @Column(name = "firstname", length = 100)
    private String firstname;

    @Column(name = "middleName",  length = 40)
    private String middleName;

    @Column(name = "lastName",  length = 40)
    private String lastName;

    @Column(name = "username",  length = 100)
    public String username;     //i'm thinking this needs to be public user username;

    @Column(name = "email")
    private String email;

    @Column(name = "password",   length = 100)
    private String password;

    @Column(name = "profile", nullable = true)
    private String profile;

    @Column(name = "mobile", nullable = false, length = 36)
    private long mobile;

    @Column(name = "status", nullable = true)
    private String status;


    // add local politicians twitters by zip code
    @Column(name = "zip")
    private String zip;

    @Column(name = "imgPath")
    private String imgPath;

    @Column(name = "originalavatar")
    private String originalavatar;

    @Column
    private boolean isAdmin;

    @Column(name = "banner")
    private String banner;

//    LOB should let us use as much text as we want
    @Lob
    @Column(name = "bio")
    private String bio;

//    links

    @Column(name = "link1")
    private String link1;

    @Column(name = "link2")
    private String link2;

    @Column(name = "link3")
    private String link3;





    // [][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] mySQL Relationships[][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postOwner")
    @JsonBackReference
    private List<usersPost> blogPost;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusOwner")
    @JsonBackReference
    private Collection<status> usersStatus;


//    groups

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupMember")
    @JsonBackReference
    private List<groups> groupMember;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupComment")
//    @JsonBackReference
//    private Collection<groupComment> groupComment;

//    friends

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerUser")
    @JsonBackReference
    private Collection<friendslist> contactListOwner;

//    token

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tokenOwner")
    @JsonBackReference
    private Collection<Token> receivedTokens;


//    @OneToMany
//    @JoinColumn(name = "groupOWner")
//    public List<groups> groupOwner;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "added_user_id", fetch = FetchType.EAGER)
//    @JsonBackReference
//    private Collection<friendslist> contactListEntity;




    // Insert Constructor

    public user(String firstname, String middleName, String lastName, String username, String email, String password, String profile, long mobile, String status, String imgPath, String originalavatar, boolean isAdmin, String banner, String bio, String link1, String link2, String link3, List<usersPost> blogPost, Collection<com.home.towers.models.status> usersStatus, List<groups> groupMember, Collection<friendslist> contactListOwner, Collection<Token> receivedTokens) {
        this.firstname = firstname;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.mobile = mobile;
        this.status = status;
        this.imgPath = imgPath;
        this.originalavatar = originalavatar;
        this.isAdmin = isAdmin;
        this.banner = banner;
        this.bio = bio;
        this.link1 = link1;
        this.link2 = link2;
        this.link3 = link3;
        this.blogPost = blogPost;
        this.usersStatus = usersStatus;
        this.groupMember = groupMember;
//        this.groupComment = groupComment;
        this.contactListOwner = contactListOwner;
        this.receivedTokens = receivedTokens;
    }


    // update Constructor

    public user(long id, String firstname, String middleName, String lastName, String username, String email, String password, String profile, long mobile, String status, String imgPath, String originalavatar, boolean isAdmin, String banner, String bio, String link1, String link2, String link3, List<usersPost> blogPost, Collection<com.home.towers.models.status> usersStatus, List<groups> groupMember, Collection<friendslist> contactListOwner, Collection<Token> receivedTokens) {
        this.id = id;
        this.firstname = firstname;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.mobile = mobile;
        this.status = status;
        this.imgPath = imgPath;
        this.originalavatar = originalavatar;
        this.isAdmin = isAdmin;
        this.banner = banner;
        this.bio = bio;
        this.link1 = link1;
        this.link2 = link2;
        this.link3 = link3;
        this.blogPost = blogPost;
        this.usersStatus = usersStatus;
        this.groupMember = groupMember;
//        this.groupComment = groupComment;
        this.contactListOwner = contactListOwner;
        this.receivedTokens = receivedTokens;
    }


    // Copy Constructor


    public user(user copy) {
        id = copy.id;
        firstname = copy.firstname;
        middleName = copy.middleName;
        lastName = copy.lastName;
        username = copy.username;
        email = copy.email;
        password = copy.password;
        profile = copy.profile;
        mobile = copy.mobile;
        status = copy.status;
        imgPath = copy.imgPath;
        originalavatar = copy.originalavatar;
        blogPost = copy.blogPost;
        contactListOwner = copy.contactListOwner;


    }




    // GETTERS AND SETTERS


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getOriginalavatar() {
        return originalavatar;
    }

    public void setOriginalavatar(String originalavatar) {
        this.originalavatar = originalavatar;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLink1() {
        return link1;
    }

    public void setLink1(String link1) {
        this.link1 = link1;
    }

    public String getLink2() {
        return link2;
    }

    public void setLink2(String link2) {
        this.link2 = link2;
    }

    public String getLink3() {
        return link3;
    }

    public void setLink3(String link3) {
        this.link3 = link3;
    }

    public List<usersPost> getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(List<usersPost> blogPost) {
        this.blogPost = blogPost;
    }

    public Collection<com.home.towers.models.status> getUsersStatus() {
        return usersStatus;
    }

    public void setUsersStatus(Collection<com.home.towers.models.status> usersStatus) {
        this.usersStatus = usersStatus;
    }

    public Collection<groups> getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(List<groups> groupMember) {
        this.groupMember = groupMember;
    }

//    public Collection<com.home.towers.models.groupComment> getGroupComment() {
//        return groupComment;
//    }
//
//    public void setGroupComment(Collection<com.home.towers.models.groupComment> groupComment) {
//        this.groupComment = groupComment;
//    }

    public Collection<friendslist> getContactListOwner() {
        return contactListOwner;
    }

    public void setContactListOwner(Collection<friendslist> contactListOwner) {
        this.contactListOwner = contactListOwner;
    }

    public Collection<Token> getReceivedTokens() {
        return receivedTokens;
    }

    public void setReceivedTokens(Collection<Token> receivedTokens) {
        this.receivedTokens = receivedTokens;
    }
}
