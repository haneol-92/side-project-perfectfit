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
@Table(name="order_cancel")
public class OrderCancel {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer cancel_seq; // 취소 번호

  @NotNull
  private Integer order_seq; // 결제 번호(FK)

  /*********************취소 공통코드*********************/
  @Column(length = 500)
  private String up_code; // 공통 코드: 취소 사유

  @Column(length = 500)
  private String info_code; // 공통 코드(A:고객 변심)
  /****************************************************/

  @Column(length = 500)
  private String cancel_content; // 취소 사유

  @Column(length = 1)
  @NotNull
  private String cancel_type = "M"; // 환불 방법

  @Column(length = 500)
  private String bank_code; // 공통코드 : 통장(무통장인 경우)

  @Column(length = 500)
  private String bank_number; // 환불 계좌 정보

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
