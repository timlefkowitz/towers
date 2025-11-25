package com.home.towers.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="groupMember")
public class groupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name="list_owner_id")
    @JsonManagedReference
    private groups ownerUser;

    @ManyToOne
    @JoinColumn(name="added_user_id")
    @JsonManagedReference
    private user groupMember;

//    @Override
//    public String toString() {
//        return "groupMember{" +
//                "id=" + id +
//                ", ownerUser=" + ownerUser +
//                ", groupMember=" + groupMember +
//                '}';
//    }

    public groupMember(long id, groups ownerUser, user groupMember) {
        this.id = id;
        this.ownerUser = ownerUser;
        this.groupMember = groupMember;
    }

    public groupMember(groups ownerUser, user groupMember) {
        this.ownerUser = ownerUser;
        this.groupMember = groupMember;
    }

    public groupMember() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public groups getOwnerUser() {
        return ownerUser;
    }

//    public void setOwnerUser(groups ownerUser) {
//        this.ownerUser = ownerUser;
//    }
//
//    public user getGroupMember() {
//        return groupMember;
//    }
//
//    public void setGroupMember(user added_user_id) {
//        this.groupMember = added_user_id;
//    }
}
