package com.example.api.service;

import com.example.api.entity.UserInfo;
import com.example.api.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService{

    private final UserServiceRepository userServiceRepository;

    @Transactional
   public boolean findByUseridAndPasswd(String userId, String passwd) {

        List<User> user = userServiceRepository.findByUseridAndPasswd(userId, passwd);
        if(user.size() == 0 || user.isEmpty()){
            return false;
        }
        return true;
    }

    @Transactional
    public User insertUser(UserInfo userinfo){
        User user = new User();

        user.setUserid(userinfo.getUserid());
        user.setPasswd(userinfo.getPasswd());
        user.setName(userinfo.getName());
        user.setPhone(userinfo.getPhone());
        user.setSex(userinfo.getSex());


        return userServiceRepository.save(user);
    }
}
