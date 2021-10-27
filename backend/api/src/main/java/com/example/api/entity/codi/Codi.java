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
@Table(name="codi")
public class Codi {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer codi_seq; // 코디북 영상 번호

  @Column(length = 11)
  private Integer img_seq; // 이미지 공통파일 FK

  @Column(length = 500)
  private String title; // 제목

  @Column(length = 11)
  private Integer member_seq; // 사용자 번호

  @Column(length = 11)
  private int view_cnt; // 조회수

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
