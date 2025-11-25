package com.home.towers.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="status")
public class status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "statusOwner")
    private user statusOwner;

    @Column(length = 3096)
    private String status;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusComments")
//    @JsonBackReference
//    private Collection<comment> usersStatus;

    //insert

    public status(user statusOwner, String status) {
        this.statusOwner = statusOwner;
        this.status = status;

    }


    //update


    public status(long id, user statusOwner, String status) {
        this.id = id;
        this.statusOwner = statusOwner;
        this.status = status;
    }

    public status() {

    }


    //getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public user getStatusOwner() {
        return statusOwner;
    }

    public void setStatusOwner(user statusOwner) {
        this.statusOwner = statusOwner;
    }

//    public Collection<comment> getUsersStatus() {
//        return usersStatus;
//    }
//
//    public void setUsersStatus(Collection<comment> statusComments) {
//        this.usersStatus = statusComments;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
