package com.example.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sports {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int sq;

  private String sport_name;

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

  public int getSq() {
    return sq;
  }

  public String getSport_name() {
    return sport_name;
  }
}
