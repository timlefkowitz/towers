package com.home.towers.models;

import javax.persistence.*;

@Entity // << this is how hibernate knows to make tables out of the class
@Table(name="groupPost")
public class groupPost {

    public groupPost(){

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "ownerOfPost")
    private String ownerOfPost;

    @Column(name = "body")
    private String body;

    @Column(name = "stashFileStackURL2")
    private String imgPath;

    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] mySQL Relationships[][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //


    @ManyToOne
    @JoinColumn(name = "groupPost")
    private user groupPost;











    //Insert

    public groupPost(String title, String ownerOfPost, String body, String imgPath) {
        this.title = title;
        this.ownerOfPost = ownerOfPost;
        this.body = body;
        this.imgPath = imgPath;
    }


    //update

    public groupPost(long id, String title, String ownerOfPost, String body, String imgPath) {
        this.id = id;
        this.title = title;
        this.ownerOfPost = ownerOfPost;
        this.body = body;
        this.imgPath = imgPath;
    }


    //getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnerOfPost() {
        return ownerOfPost;
    }

    public void setOwnerOfPost(String ownerOfPost) {
        this.ownerOfPost = ownerOfPost;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
