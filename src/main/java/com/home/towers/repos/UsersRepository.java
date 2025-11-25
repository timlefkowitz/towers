package com.home.towers.repos;


import com.home.towers.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<user, Long> {


//    user findByUsername(String userName);
    user getByUsername(String statusOwner);
    user findByUsername(String username);


//    user getBycontactListOwner(String username);
//    user getByBlogPost(user BlogPost);
//
//    String getUsername(String username);
}
