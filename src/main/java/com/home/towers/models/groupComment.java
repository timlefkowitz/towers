//package com.home.towers.models;
//
//import javax.persistence.*;
//
//@Entity // << this is how hibernate knows to make tables out of the class
//@Table(name="groupComment")
//public class groupComment {
//
//    public groupComment(){
//
//    }
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;
//
//    @ManyToOne
//    @JoinColumn(name = "groupComment")
//    private groups groupComment;
//
//    //insert
//
//    public groupComment(groups groupComment) {
//        this.groupComment = groupComment;
//    }
//
//
//    //update
//
//    public groupComment(long id, groups groupComment) {
//        this.id = id;
//        this.groupComment = groupComment;
//    }
//
//
//    //getters and setters
//
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public groups getGroupComment() {
//        return groupComment;
//    }
//
//    public void setGroupComment(groups groupComment) {
//        this.groupComment = groupComment;
//    }
//}
