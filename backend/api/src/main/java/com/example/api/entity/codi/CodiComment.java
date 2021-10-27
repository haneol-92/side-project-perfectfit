package com.example.api.entity.codi;

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
@Table(name="codi_comment")
public class CodiComment {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer comment_seq; // 코디북 댓글 번호

  @Column(length = 11)
  private Integer codi_seq; // 코디북 번호 FK

  @Column(length = 11)
  private Integer memeber_seq; // 일반 회원 FK

  @Column(length = 11)
  private Integer parent_seq; // 부모댓글 뎁스 1인경우 0으로
 
  private String content; // 댓글 내용
  
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
