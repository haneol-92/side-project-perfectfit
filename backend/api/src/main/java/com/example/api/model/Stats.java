package com.example.api.model;

import javax.persistence.*;

@Entity
public class Stats {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int sq;

  @OneToOne
  private Matching matchingId;

  private String score_Home;
  private String score_Away;

  @OneToOne
  private Matching won;

  @OneToOne
  private Matching lost;

  @OneToOne
  private Matching draw;

  private String attr1;
  private String attr2;
  private String attr3;
  private String attr4;
  private String attr5;
  private String attr6;
  private String attr7;
  private String attr8;
  private String attr9;
  private String attr10;

  public Matching getMatchingId() {
    return matchingId;
  }
}
