package com.example.api.controller;

import com.example.api.beans.ResultList;
import com.example.api.entity.Team;
import com.example.api.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamController {

  private final TeamService teamService;

  @GetMapping(path = "/teams")
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity<ResultList<Team>> getTeams() {
    var teams = teamService.getAllTeams();
    return ResponseEntity.ok(ResultList.<Team>builder().results(teams).build());
  }
}
