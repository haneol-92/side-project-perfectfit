package com.example.api.entity.coupon;

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
@Table(name="coupon")
public class Coupon {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer coupon_seq; // 쿠폰 번호

  @Column(length = 500)
  private String name; // 쿠폰 명

  private String content; // 쿠폰 설명

  @Column(length = 11)
  private int amount; // 할인 금액

  @Column(length = 11)
  private int max_amount; // 할인 금액 사용을 위한 최소 금액

  @Column(length = 11)
  private int use_day; // 쿠폰 유효 기간

  @Column(length = 500)
  private String start_dt; // 쿠폰 명

  @Column(length = 500)
  private String end_dt; // 쿠폰 명

  @CreationTimestamp
  private Instant create_dt; // 생성 일자

  @CreationTimestamp
  private Instant update_dt; // 업데이트 일자

  @CreationTimestamp
  private Instant delete_dt; // 삭제 일자

  @Column(length = 1)
  @NotNull
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
