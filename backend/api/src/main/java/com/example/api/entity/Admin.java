package com.example.api.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer admin_seq; // 어드민 번호

    @Column(length = 500)
    private String id; // 관리자 아이디

    @Column(length = 500)
    private String pw; // 관리자 패스워드

    @Column(length = 500)
    private String name; // 관리자 이름

    @Column(length = 500)
    private String img_url; // 이미지 url

    @Column(length = 500)
    private String nickname; // 관리자 별칭

    @Column(length = 500)
    private String phone; // 관리자 전화번호

    @CreationTimestamp
    private Instant create_dt; // 생성 일자

    @CreationTimestamp
    private Instant update_dt; // 업데이트 일자

    @CreationTimestamp
    private Instant delete_dt; // 삭제 일자

    @Column(length = 1)
    private String show_yn = "Y"; // 사용자단 노출여부

    @Column(length = 1)
    @NotNull
    private String delete_yn = "N"; // 삭제여부

    @Column(length = 11)
    private int create_by; // 생성 관리자 key (관리자단에서 사용)

    @Column(length = 11)
    private int update_by; // 수정 관리자 key (관리자단에서 사용)

    @Column(length = 11)
    private int delete_by; // 삭제 관리자 key (관리자단에서 사용)
}
