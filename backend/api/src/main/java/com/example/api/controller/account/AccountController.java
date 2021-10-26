package com.example.api.controller.account;

import com.example.api.beans.UserInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.api.security.JwtService;
import com.example.api.service.account.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/account")
public class AccountController {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final UserService userService;

  private final JwtService jwtService;

  @GetMapping(path = "/user")
  public String getUsers(@RequestBody(required = false) UserInfo userinfo) {

    logger.info("loggin test");

    return "1";
  }

  @PostMapping(path = "/login")
  public ResponseEntity<Map<String, Object>> userLogin(@RequestBody(required = false) UserInfo userinfo,
                                                       HttpServletResponse response) throws Exception{

    var resultMap = new HashMap<String, Object>();

    try{

      // 로그인 시도한 아이디와 패스워드가 맞는지에 대한 체
      if(!userService.findByUseridAndPasswd(userinfo.getUserid(), userinfo.getPasswd())){
        resultMap.put("status", false);
        return new ResponseEntity<>(resultMap, HttpStatus.UNAUTHORIZED);
      }

      //해당 사용자가 휴면인지 아닌지 체크
      if(!userService.checkStatus(userinfo.getUserid(), 1)){
        resultMap.put("status", false);
        return new ResponseEntity<>(resultMap, HttpStatus.UNAUTHORIZED);
      }
      
      String token = jwtService.createToken(userinfo);

      response.setHeader("jwt-auth-token", token);

      resultMap.put("token",response.getHeader("jwt-auth-token"));
      resultMap.put("status", true);
      resultMap.put("data",userinfo);

    }catch(Exception e){
      throw e;
    }

    return ResponseEntity.ok(resultMap);
  }

  @PostMapping(path = "/useradd")
  public String addUser(@RequestBody UserInfo userinfo) {

    userService.insertUser(userinfo);

    return "Join";
  }

  @PostMapping(path = "/idcheck")
  public boolean idCheck(@RequestBody String userid){

    boolean result = userService.checkId(userid);
    System.out.println(result);
    return result;
  }
}
