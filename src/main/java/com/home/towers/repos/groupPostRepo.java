package com.home.towers.repos;


import com.home.towers.models.groupPost;
import com.home.towers.models.groups;
import com.home.towers.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface groupPostRepo extends JpaRepository<groupPost, Long> {


//    coming back to this in the future
//    user findByUsername(String userName);
//    user getByUsername(String username);
//    groups findByGroupName(String title);
}
