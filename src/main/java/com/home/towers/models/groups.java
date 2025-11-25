package com.home.towers.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity // << this is how hibernate knows to make tables out of the class
@Table(name="groupTable")
public class groups {

    public groups(){

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "CreatedBy")
    private String CreatedBy;

    @Column(name = "title")
    private String title;

    @Column(name = "summary")
    private String summary;

    @Column(name = "profile")
    private String profile;

    @Column( name = "content")
    private String content;

    @Column(name = "groupavatar")
    private String groupavatar;



    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][] mySQL Relationships[][][][][][][][][][][][][][][][][]
    //[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]
    //

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupPost")
    @JsonBackReference
    private List<groupPost> groupPost;

    @ManyToOne
    @JoinColumn(name = "groupComment")
    private groups groupComment;

    @ManyToOne
    @JoinColumn(name = "groupOwner")
    private user groupOwner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerUser")
    @JsonBackReference
    private Collection<groupMember> groupMember;


    // THERE CAN BE MANY OWNERS THAT OWN THINGS???????




    // Insert Constructor

    public groups(String createdBy, String title, String summary, String profile, String content, String groupavatar, List<com.home.towers.models.groupPost> groupPost, groups groupComment, user groupOwner, Collection<com.home.towers.models.groupMember> groupMember) {
        CreatedBy = createdBy;
        this.title = title;
        this.summary = summary;
        this.profile = profile;
        this.content = content;
        this.groupavatar = groupavatar;
        this.groupPost = groupPost;
        this.groupComment = groupComment;
        this.groupOwner = groupOwner;
        this.groupMember = groupMember;
    }


    // Update Constructor


    public groups(long id, String createdBy, String title, String summary, String profile, String content, String groupavatar, List<com.home.towers.models.groupPost> groupPost, groups groupComment, user groupOwner, Collection<com.home.towers.models.groupMember> groupMember) {
        this.id = id;
        CreatedBy = createdBy;
        this.title = title;
        this.summary = summary;
        this.profile = profile;
        this.content = content;
        this.groupavatar = groupavatar;
        this.groupPost = groupPost;
        this.groupComment = groupComment;
        this.groupOwner = groupOwner;
        this.groupMember = groupMember;
    }

    public groups(groups groupMember, user addthisUser) {
    }


    // Getters and Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGroupavatar() {
        return groupavatar;
    }

    public void setGroupavatar(String groupavatar) {
        this.groupavatar = groupavatar;
    }

    public List<com.home.towers.models.groupPost> getGroupPost() {
        return groupPost;
    }

    public void setGroupPost(List<com.home.towers.models.groupPost> groupPost) {
        this.groupPost = groupPost;
    }

    public groups getGroupComment() {
        return groupComment;
    }

    public void setGroupComment(groups groupComment) {
        this.groupComment = groupComment;
    }

    public user getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(user groupOwner) {
        this.groupOwner = groupOwner;
    }

    public Collection<com.home.towers.models.groupMember> getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(Collection<com.home.towers.models.groupMember> groupMember) {
        this.groupMember = groupMember;
    }
}
