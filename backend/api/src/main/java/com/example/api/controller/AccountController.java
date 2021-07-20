package com.example.api.controller;

import com.example.api.entity.UserInfo;
import com.example.api.model.User;

import com.example.api.security.JwtService;
import com.example.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AccountController {

  private final UserService userService;

  private final JwtService jwtService;

  @PostMapping(path = "/user")
  public String getUsers(@RequestBody UserInfo userinfo) {

    return "1";
  }

  @PostMapping(path = "login")
  public ResponseEntity<Map<String, Object>> userLogin(@RequestBody UserInfo userinfo, HttpServletResponse response) throws Exception{

    Map<String, Object> resultMap = new HashMap<>();
    HttpStatus status = null;

    try{

      if(!userService.findByUseridAndPasswd(userinfo.getUserid(), userinfo.getPasswd())){
        resultMap.put("status", false);
        status = HttpStatus.CONFLICT;
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
      }
      String token = jwtService.createToken(userinfo);

      response.setHeader("jwt-auth-token", token);

      resultMap.put("token",response.getHeader("jwt-auth-token"));
      resultMap.put("status", true);
      resultMap.put("data",userinfo);
      status = HttpStatus.ACCEPTED;

    }catch(Exception e){
      throw e;
    }
    return new ResponseEntity<Map<String, Object>>(resultMap, status);
  }

  @PostMapping(path = "/useradd")
  public String addUser(@RequestBody UserInfo userinfo) {

    userService.insertUser(userinfo);

    return "Join";
  }
}
