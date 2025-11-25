package com.home.towers.repos;


import com.home.towers.models.friendslist;
import com.home.towers.models.user;
import com.home.towers.models.usersPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UsersPostRepo extends JpaRepository<usersPost, Long> {

    usersPost getById(long id);

//    Collection<UsersPostRepo> getByOwnerUser(user userOfCurrentProfile);

    Collection<UsersPostRepo> getByPostOwner(user userOfCurrentProfile);

//    List<friendslist> getByOwnerUser(user OwnerUser);


//    usersPost findByOwner(user Owner);
//    String findAllByUsername(String username);
//    usersPost getByUsername(String username);
//    usersPost findByOwner(user Owner);
}
