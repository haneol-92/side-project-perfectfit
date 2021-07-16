package com.example.api.controller;

import com.example.api.entity.UserInfo;
import com.example.api.model.User;

import com.example.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
public class AccountController {

  private final UserService userService;

  @PostMapping(path = "/users")
  public String getUsers(@RequestBody UserInfo userinfo) {

    return "Hello World";
  }

  @PostMapping(path = "/useradd")
  public String addUser(@RequestBody UserInfo userinfo) {

    userService.insertUser(userinfo);

    return "Join";
  }
}
