package com.example.api.model;

import javax.persistence.*;

@Entity
public class Team {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer sq;

  @OneToOne(cascade = CascadeType.ALL)
  private Sports sports;

  private String teamId;
  private String teamName;

  @OneToOne
  private Region region;

  @OneToOne(cascade = CascadeType.ALL)
  private User ownerId;

  public Sports getSports() {
    return sports;
  }
}
