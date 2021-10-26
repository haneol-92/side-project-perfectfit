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
@Table(name="order_noti")
public class OrderNoti {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer noti_seq; // 주문 상품 문의 고유 번호

  @NotNull
  private Integer order_seq; // 주문 번호(FK)

  @Column(length = 500)
  private String up_code; // 공통코드 : 문의 카테고리

  @Column(length = 500)
  private String info_code; // 공통코드 : 문의 상세 카테고리

  private String content; // 문의 내용

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
