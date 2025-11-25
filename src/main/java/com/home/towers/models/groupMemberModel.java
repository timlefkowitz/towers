package com.home.towers.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="groupMemberModel")
public class groupMemberModel implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "group_id")
    private Long groupId;


}
