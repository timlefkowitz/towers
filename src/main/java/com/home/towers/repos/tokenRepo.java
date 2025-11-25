package com.home.towers.repos;


import com.home.towers.models.Token;
import com.home.towers.models.usersPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface tokenRepo extends JpaRepository<Token, String> {

        usersPost getById(long id);

//    String findAllByUsername(String username);
//    usersPost getByUsername(String username);


//    usersPost findByOwner(user Owner);
        }
