package com.example.api.entity.order;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@ToString
@Table(name="order_delivery")
public class OrderDelivery {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer delivery_seq; // 주문 배송 고유 번호

  @NotNull
  private Integer order_seq; // 주문 번호(FK)

  @Column(length = 500)
  private String name; // 주문자명

  @Column(length = 500)
  private String phone; // 주문자 전화번호

  @Column(length = 500)
  private String post; // 주문자 우편번호

  @Column(length = 500)
  private String addr; // 주문 주소

  @Column(length = 500)
  private String addr_sub; // 주문 상세 주소

  @Column(length = 500)
  private String up_code; // 공통코드 : 배송메모

  @Column(length = 500)
  private String info_code; // 공통코드 : 배송메모

  private String memo; // 주문 메모

  @CreationTimestamp
  private Instant create_dt; // 생성 일자

  @CreationTimestamp
  private Instant update_dt; // 업데이트 일자

  @CreationTimestamp
  private Instant delete_dt; // 삭제 일자

  @Column(length = 1)
  private String show_yn = "Y"; // 사용자단 노출여부

  @Column(length = 1)
  private String delete_yn = "N"; // 삭제여부

  @Column(length = 11)
  private int create_by; // 생성 관리자 key (관리자단에서 사용)

  @Column(length = 11)
  private int update_by; // 수정 관리자 key (관리자단에서 사용)

  @Column(length = 11)
  private int delete_by; // 삭제 관리자 key (관리자단에서 사용)

}
