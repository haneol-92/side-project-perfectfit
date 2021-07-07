package com.example.api.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Matching {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer sq;
  private String status;
  private Instant matching_date;

  @OneToOne(cascade = CascadeType.ALL)
  private Team teamId_Home;

  @OneToOne(cascade = CascadeType.ALL)
  private Team teamId_Away;

  public Team getTeamId_Home() {
    return teamId_Home;
  }
}
