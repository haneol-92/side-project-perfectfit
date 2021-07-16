package com.example.api.controller;

import com.example.api.model.Stats;
import com.example.api.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @PostMapping(path = "/users")
  @CrossOrigin(origins = "http://localhost:8081")
  public String getUsers(@RequestBody final User user) {

    System.out.println("Hello~~"+ user.toString());
    return "Hello World";
  }
}
