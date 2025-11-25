package com.home.towers.repos;


import com.home.towers.models.friendslist;
import com.home.towers.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface friendslistrepo extends JpaRepository<friendslist, Long> {

    List<friendslist> getByOwnerUser(user OwnerUser);


}
