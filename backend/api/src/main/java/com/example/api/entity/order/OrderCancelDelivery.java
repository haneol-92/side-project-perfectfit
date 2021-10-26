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
@Table(name="order_cancel_delivery")
public class OrderCancelDelivery {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer cancel_delivery_seq; // 취소 고유 번호

  @NotNull
  private Integer cancel_seq; // 상품 번호(FK)

  /*********************취소 공통코드*********************/
  @Column(length = 500)
  private String up_code; // 공통 코드: 택배사

  @Column(length = 500)
  private String info_code; // 공통 코드(HJ:한진택배)
  /****************************************************/

  @Column(length = 500)
  private String delivery_code; // 개별반품 송장 번호

  private String memo; // 반품 요청 메세지

  @Column(length = 500)
  private String post; // 환불 주소 우편번호

  @Column(length = 500)
  private String addr; // 환불 주소

  @Column(length = 500)
  private String addr_sub; // 환불 상세 주소

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
