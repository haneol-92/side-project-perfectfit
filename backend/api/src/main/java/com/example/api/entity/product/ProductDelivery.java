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
@Table(name="product_delivery")
public class ProductDelivery {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer delivery_seq; // 상품연령 번호

  @Column(length = 11)
  private Integer product_seq; // 상품 번호

  @Column(length = 11)
  private int fee; // 배송비

  @Column(length = 1)
  private String is_free_fee ; // 무료 배송 여부

  @Column(length = 1)
  private String benefit_price_yn ; // 특정 금액 구매 이상 무료 배송 여부

  @Column(length = 11)
  private int benefit_price; // 무료 배송을 위한 특정 이상 구매 가격

  @Column(length = 11)
  private int delivery_day; // 배송 기간

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
