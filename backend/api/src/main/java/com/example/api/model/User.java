package com.example.api.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer sq;

  @NotNull
  private String userid;
  @NotNull
  private String passwd;

  @Column(length = 20)
  @NotNull
  private String name;

  @Column(length = 1)
  @NotNull
  private String sex;

  @Column(length = 13)
  private String phone;

  private Instant birth;

  @CreationTimestamp
  private Instant createdAt;

  @UpdateTimestamp
  private Instant updatedAt;
}
