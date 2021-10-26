package com.example.api.service.account;

import com.example.api.beans.UserInfo;
import com.example.api.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


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
        user.setStatus(1);

        return userServiceRepository.save(user);
    }

    @Transactional
    public boolean checkId(String userId) {
        List<User> user = userServiceRepository.findByUserid(userId);
        if(user.size() == 0 || user.isEmpty())
            return true;
        else return false;
    }

    @Transactional
    public boolean checkStatus(String userId,int status){
        List<User> user = userServiceRepository.findByUseridAndStatus(userId,status);
        if(user.size() == 0 || user.isEmpty()){
            return false;
        }
        return true;
    }

}
