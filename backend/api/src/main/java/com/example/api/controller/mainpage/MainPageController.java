package com.example.api.controller.mainpage;

import com.example.api.dto.AdminInfo;
import com.example.api.dto.UserInfo;
import com.example.api.security.JwtService;
import com.example.api.service.account.AdminService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/main")
public class MainPageController {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private final AdminService adminService;

  @Autowired
  private final JwtService jwtService;

  @GetMapping(path = "/test")
  public String getUsers(@RequestBody(required = false) UserInfo userinfo) {

    logger.info("main page test");

    return "1";
  }

  @PostMapping(path = "/view")
  public ResponseEntity<Map<String, Object>> mainPage(@RequestBody(required = false) AdminInfo adminInfo,
                                                       HttpServletResponse response) throws Exception{

    var resultMap = new HashMap<String, Object>();

    try{
      
      //파라미터 기본 오늘 날짜

      //주문 접수 건수 가져오기
      
      //결제 확인 건수 가져오기

      //매출 가져오기

      //적립포인트 가져오기

      //주문 처리 최근 100일 가져오기

      //알람 유무 여부

      //문의 현황 퍼센테이지

      //

      resultMap.put("data",adminInfo);

    }catch(Exception e){
      throw e;
    }

    return ResponseEntity.ok(resultMap);
  }


  @PostMapping(path = "/search")
  public boolean searchData(@RequestBody String userid){

    return true;
  }
}
