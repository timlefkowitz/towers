package com.home.towers.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.home.towers.repos.UsersRepository;
import org.apache.tomcat.jni.User;

import javax.persistence.*;

@Entity
@Table(name="hashedPosts")
public class Token {

    public Token(){

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column
    private String hashedPostFinalString;

    @Lob
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private String hashPostTitle;


    @ManyToOne
    @JoinColumn(name="tokenOwner")
    @JsonManagedReference
    private user tokenOwner;


    // constructor

    public Token(long id, user tokenOwner, String hashedPost) {
        this.id = id;
        this.tokenOwner = tokenOwner;
        this.hashedPostFinalString = hashedPost;
    }

    // update

    public Token(user tokenOwner, String hashedPost) {
        this.tokenOwner = tokenOwner;
        this.hashedPostFinalString = hashedPost;
    }

    public Token(long id, String hashedPostFinalString, String hashPostTitle, user tokenOwner) {
        this.id = id;
        this.hashedPostFinalString = hashedPostFinalString;
        this.hashPostTitle = hashPostTitle;
        this.tokenOwner = tokenOwner;
    }


    // getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHashedPostFinalString() {
        return hashedPostFinalString;
    }

    public void setHashedPostFinalString(String hashedPostFinalString) {
        this.hashedPostFinalString = hashedPostFinalString;
    }

    public String getHashPostTitle() {
        return hashPostTitle;
    }

    public void setHashPostTitle(String hashPostTitle) {
        this.hashPostTitle = hashPostTitle;
    }

    public user getTokenOwner() {
        return tokenOwner;
    }

    public void setTokenOwner(user tokenOwner) {
        this.tokenOwner = tokenOwner;
    }
}
