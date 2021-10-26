package com.example.api.entity.common;

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
@Table(name="common_log")
public class CommonLog {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer log_seq; // 로그 번호

  @Column(length = 45)
  private String type; // 로그 타입

  @Column(length = 45)
  private String success; // 성공 여부

  @Column(length = 45)
  private String fail; // 실패 여부

  private String req_data; // 요청 데이터

  private String res_data; // 응답 데이터

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
