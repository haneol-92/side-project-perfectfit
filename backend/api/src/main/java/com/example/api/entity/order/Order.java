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
@Table(name="order")
public class Order {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer order_seq; // 주문 번호

  @NotNull
  private Integer member_seq; // 주문자 번호

  @NotNull
  private String payment_type; // 결제 수단

  @Column(length = 11)
  private Integer amount; // 최종 결제 금액

  /*********************주문 공통코드*********************/
  @Column(length = 500)
  private String order_up_code; // 상태 코드

  @Column(length = 500)
  private String order_info_code; // 상태 코드

  @Column(length = 500)
  private String store_up_code; // 상태 코드

  @Column(length = 500)
  private String store_info_code; // 상태 코드
  /****************************************************/

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
