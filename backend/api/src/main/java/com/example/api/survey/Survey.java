package com.example.api.survey;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Table(name="survey")
public class Survey {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer survey_seq; // 설문조사 번호

    @Column(length = 500)
    private String group_code; // 문항

    @Column(length = 500)
    private String survey_number; // 설문조사 번호

    @Column(length = 500)
    private String title; // 설문조사 제목
    
    private String content; // 설문조사 내용 (문항 설명)

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
