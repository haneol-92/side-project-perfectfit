package com.example.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.Instant;


@Getter
@Setter
@ToString
public class AdminInfo {

    private Integer admin_seq; // 어드민 번호
    private String id; // 관리자 아이디
    private String pw; // 관리자 패스워드
    private String name; // 관리자 이름
    private String img_url; // 이미지 url
    private String nickname; // 관리자 별칭
    private String phone; // 관리자 전화번호
    private Instant create_dt; // 생성 일자
    private Instant update_dt; // 업데이트 일자
    private Instant delete_dt; // 삭제 일자
    private String show_yn = "Y"; // 사용자단 노출여부
    private String delete_yn = "N"; // 삭제여부
    private int create_by; // 생성 관리자 key (관리자단에서 사용)
    private int update_by; // 수정 관리자 key (관리자단에서 사용)
    private int delete_by; // 삭제 관리자 key (관리자단에서 사용)

    public AdminInfo() {

    }
}