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
@Table(name="product_option_info")
public class ProductOptionInfo {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer product_option_info_seq; // 상품 옵션 정보 번호

  @Column(length = 11)
  private Integer option_info_seq; // 옵션 번호

  @Column(length = 11)
  private Integer product_option_seq; // 상품 번호

  @Column(length = 11)
  private int plus_amount; // 추가 금액

  @Column(length = 11)
  private Integer sort; // 정렬

  @Column(length = 11)
  private Integer stock; // 재고

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
