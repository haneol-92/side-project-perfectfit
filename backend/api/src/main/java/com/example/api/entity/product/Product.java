package com.example.api.entity.product;

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
@Table(name="product")
public class Product {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer product_seq; // 주문 번호

  @Column(length = 500)
  private String seller_code; // 판매자 상품 코드

  @Column(length = 500)
  private String name; // 상품명

  @Column(length = 500)
  private String p_name; // 퍼펙트핏 전용 상품명

  @Column(length = 500)
  private String model_name; // 모델명

  @Column(length = 500)
  private String supplier; // 제조사명

  @Column(length = 11)
  private Integer store_seq; // 최종 결제 금액

  @Column(length = 11)
  private Integer c_seq; // 2차 카테고리 번호

  @Column(length = 500)
  private String status_up_code; // 상태 코드 : PRODUCT

  @Column(length = 500)
  private String status_info_code; // 상태 코드

  @Column(length = 500)
  private String sale_start_dt; // 할인 시작 날짜

  @Column(length = 500)
  private String sale_end_dt; // 할인 종료 날짜

  @Column(length = 1)
  private String sale_yn; // 할인 여부

  @Column(length = 11)
  private int discount; // 할인율

  @Column(length = 500)
  private int discount_range; // 할인율 범위

  @Column(length = 11)
  private int stock; // 재고

  @Column(length = 11)
  private int before_amount; // 기존가

  @Column(length = 11)
  private int amount; // 현재가

  @Column(length = 1)
  private String free_delivery_yn; // 무료 배송 여부

  @Column(length = 1)
  private String crawling_yn; // 크롤링 상품 여부

  @Column(length = 500)
  private String open_up_code; // 전시 상태

  @Column(length = 500)
  private String open_info_code; // 전시 상태 코드

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
