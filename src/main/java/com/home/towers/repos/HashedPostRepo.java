package com.home.towers.repos;

import com.home.towers.models.friendslist;
import com.home.towers.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface HashedPostRepo extends JpaRepository<friendslist, Long> {



//    Collection<HashedPostRepo> getByOwnerUsername(user ownerUsername);


}
