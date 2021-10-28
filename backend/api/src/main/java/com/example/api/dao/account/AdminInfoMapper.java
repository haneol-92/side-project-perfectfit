package com.example.api.dao.account;

import com.example.api.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminInfoMapper {
    public List<Admin> getAdminInfo(String userid, String passwd);
    int getAdminExsist(String userid);
    public List<Admin> findByAdminid(String userid);
    public int insertUser(Admin admin);

}
