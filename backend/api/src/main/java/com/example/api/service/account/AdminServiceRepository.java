package com.example.api.service.account;

import com.example.api.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminServiceRepository{

    boolean findByAdminidAndPasswd(String userId, String passwd);
    List<Admin> findByAdminid(String userId);

}
