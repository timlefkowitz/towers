package com.home.towers.repos;


import com.home.towers.models.status;
import com.home.towers.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface statusRepo extends JpaRepository<status, String> {

//
//    user getByUsername(user username);
}
