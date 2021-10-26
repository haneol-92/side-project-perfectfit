package com.example.api.service.account;

import com.example.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserServiceRepository extends JpaRepository<User, Long> {

    List<User> findByUseridAndPasswd(String userId, String passwd);
    List<User> findByUserid(String userId);
    List<User> findByUseridAndStatus(String userId,int status);
}
