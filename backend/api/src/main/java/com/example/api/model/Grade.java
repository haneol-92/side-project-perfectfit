package com.example.api.model;

import javax.persistence.*;

@Entity
public class Grade {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer sq;

  private String grade;

  private String comment;

  @OneToOne(cascade = CascadeType.ALL)
  private User userId;

  @OneToOne(cascade = CascadeType.ALL)
  private Team teamId;

  @OneToOne(cascade = CascadeType.ALL)
  private Matching MatchId;
}
