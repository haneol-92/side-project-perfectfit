package com.example.api.service;

import com.example.api.entity.UserInfo;
import com.example.api.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class UserService{

    private final UserServiceRepository userServiceRepository;

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
