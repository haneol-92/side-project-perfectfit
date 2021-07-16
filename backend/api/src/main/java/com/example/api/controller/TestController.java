package com.example.api.controller;

import com.example.api.model.Stats;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @PostMapping(path = "/users")
  @CrossOrigin(origins = "http://localhost:8081")
  public String getUsers() {
    System.out.println("Hello~~");
    return "Hello World";
  }
}
