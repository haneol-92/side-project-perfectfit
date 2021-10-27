package com.example.api.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;


@Getter
@Setter
@ToString
public class OrderInfo {
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

    public OrderInfo() {

    }
}