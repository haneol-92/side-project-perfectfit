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
@Table(name="product_review_result")
public class ProductReviewResult {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer result_seq; // 상품 리뷰 문항 고유 번호

  @Column(length = 11)
  private Integer product_review_seq; // 상품 리뷰 번호

  @Column(length = 11)
  private Integer review_seq; // 리뷰 카테고리 번호

  @Column(length = 11)
  private Integer example_seq; // 리뷰 미리보 번호

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
