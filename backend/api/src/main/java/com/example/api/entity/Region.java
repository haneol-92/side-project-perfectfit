package com.example.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Region {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer sq;

  private String region_name;
}
