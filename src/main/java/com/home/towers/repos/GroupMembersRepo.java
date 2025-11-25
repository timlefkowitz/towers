package com.home.towers.repos;


import com.home.towers.models.groupMember;
import com.home.towers.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMembersRepo extends JpaRepository<groupMember, Long> {
    List<groupMember> getByGroupMember_Id(long groupMember_id);


}
