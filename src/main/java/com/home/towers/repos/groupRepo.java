package com.home.towers.repos;


import com.home.towers.models.friendslist;
import com.home.towers.models.groups;
import com.home.towers.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface groupRepo extends JpaRepository<groups, Long> {

//    groups findByGroupName(String title);

    groups getByTitle(String title);
//    List<groups> getByGroupUser(user OwnerUser);
//    groups getByGroupOwner(String groupOwner);
//
//    Collection<groups> getByGroupMember(String groupMember);
}
