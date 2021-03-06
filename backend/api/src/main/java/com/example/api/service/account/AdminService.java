package com.example.api.service.account;

import com.example.api.dto.AdminInfo;
import com.example.api.dao.account.AdminInfoMapper;
import com.example.api.entity.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service
public class AdminService implements AdminServiceRepository {

    @Autowired
    private final AdminInfoMapper adminInfoMapper;

    @Transactional
    public boolean findByAdminidAndPasswd(String userId, String passwd) {

        List<Admin> admin = adminInfoMapper.getAdminInfo(userId, passwd);
        if(admin.size() == 0 || admin.isEmpty()){
            return false;
        }
        return true;
    }

//    @Override
//    public int findByAdminid(String userId) {
//
//        return adminInfoMapper.getAdminExsist(userId);
//    }

    @Transactional
    public int insertUser(AdminInfo admininfo){
        Admin admin = new Admin();

        admin.setId(admininfo.getId());
        admin.setPw(admininfo.getPw());
        admin.setName(admininfo.getName());
        admin.setPhone(admininfo.getPhone());
        admin.setNickname(admininfo.getNickname());


        return adminInfoMapper.insertUser(admin);
    }

    @Transactional
    public boolean checkId(String userId) {
        int result = adminInfoMapper.getAdminExsist(userId);
        if(result>0)
            return true;
        else return false;
    }

}
