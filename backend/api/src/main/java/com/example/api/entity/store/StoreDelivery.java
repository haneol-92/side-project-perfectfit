package com.example.api.entity.store;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Table(name="store_delivery")
public class StoreDelivery {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer delivery_seq; // 주문 번호

    @Column(length = 11)
    private Integer store_seq; // 상점 번호

    @Column(length = 500)
    private String name; // 상점 이름

    @Column(length = 500)
    private String up_code; // 공통코드

    @Column(length = 500)
    private String info_code; // 공통코드

    @Column(length = 500)
    private String shipment_post; // 배송지 우편번호

    @Column(length = 500)
    private String shipment_addr; // 배송지 주소

    @Column(length = 500)
    private String shipment_addr_sub; // 배송지 상세주소

    @Column(length = 500)
    private String return_post; // 반품/교환지 우편번호

    @Column(length = 500)
    private String return_addr; // 반품/교환지 주소

    @Column(length = 500)
    private String return_addr_sub; // 반품/교환지 상세주소

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
