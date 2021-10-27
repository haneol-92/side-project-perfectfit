package com.example.api.entity.store;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Table(name="store")
public class Store {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer store_seq; // 상점 번호

    @Column(length = 500)
    private String name; // 상점 이름

    @Column(length = 11)
    private Integer img_seq; // 이미지 번호

    @Column(length = 500)
    private String sller_type; // 1:국내, 2:해외

    @Column(length = 500)
    private String business_number; // 사업자번호

    @Column(length = 500)
    private String post; // 우편번호

    @Column(length = 500)
    private String addr; // 주소

    @Column(length = 500)
    private String addr_sub; // 상세주소

    @Column(length = 500)
    private String business_class; // 1:개인 2:법인
    
    @Column(length = 500)
    private String business_condition; // 업태

    @Column(length = 500)
    private String sector; // 업종

    @Column(length = 500)
    private String report_number; // 통신판매업신고번호

    @Column(length = 500)
    private String ceo_name; // 대표자이름 다수일경우 쉼표로 저장

    @Column(length = 1)
    private String ad_yn; // 광고 여부

    @Column(length = 1)
    private String new_writer_yn; // 신상작가여부

    @Column(length = 11)
    private Integer meber_seq; // 담당자 번호

    @Column(length = 1)
    private String calculate_type; // 1:정산대금, 2:판매자 충전금

    @Column(length = 500)
    private String calculate_bank_number; // 정산 계좌번호
    
    @Column(length = 500)
    private String best_up_code; // 공통코드 대표카테고리
    
    @Column(length = 500)
    private String best_info_code; // 공통코드 BRA:브라
    
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
