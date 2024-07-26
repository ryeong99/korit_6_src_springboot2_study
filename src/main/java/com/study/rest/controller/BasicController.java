package com.study.rest.controller;

import com.study.rest.dto.*;
import com.study.rest.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Rest Api
@Slf4j
@RestController
public class BasicController {

    @Autowired
    private ProductService productService;

    @CrossOrigin
    @PostMapping("/basic/student")
    public ResponseEntity<?> basicPost(@RequestBody ReqStudentDto reqStudentDto) {
        log.info("reqStudent : {}", reqStudentDto);
        return ResponseEntity.badRequest().body(reqStudentDto);
    }

    /*
       RESt API 
       데이터 통신을 위한 HTTP 요청 방식
       HTTP(프로토콜)을 더 유용하게 사용하기 위해 정의된 개념
       1. 요청에 대한 동작은 무조건 메소드에 따라 정의하자.
        - 데이터 추가(등록)은 POST 요청으로 하자, 그리고 POST 요청은 JSON 데이터로 요청하자
        - 데이터 조회는 GET 요청으로 하자, 그리고 GET 요청은 QueryString(Params)으로 요청하자
            ex) 주소? Key1=value1&key2=value2
        - 데이터 수정은 PUT, Patch 요청으로 하자, JSON으로 요청하자
            PUT요청과 PATCH 요청의 차이점은
              PUT = 공백 또는 NULL인 데이터도 수정을 한다.
              PATCH = 공백 또는 NULL인 데이터는 수정하지 않는다.
        - 데이터 삭제는 DELETE요청으로 하자, params로 요청하자
       2. 주소(URL) 요청 메세지,  (Resource)자원
        - URL은 가능한 동사를 사용하지 않는다. 
        - 계층 구조로 작성한다.
            ex) /집/주방/가스레인지 or /식당/주방/가스레인지 (다른 주방, 가스레인지)
        - 여청 메소드마다 작성하는 방법이 다르다.
        - 상품 등록 (POST) / PRODUCT
        - 상품 하나(단건) 조회(GET) /product/1(id, key)
        - 상품 여러개(다건) 조회(GET) /products(전체조회)/ product?page = 1&count=30(한 페이지에 30개 조회)
        - 상품 수정(PUT) /product/1(id, key)
        - 상품 삭제(DELETE) /product/1(id, key)
       3. 주소는 가능한 대문자를 사용하지 않는다.
     */
    @CrossOrigin
    @PostMapping("/api/v1/product")
    public ResponseEntity<?> registerProduct(@RequestBody ProductDto.Register register) {
        return ResponseEntity.ok().body(productService.registerProduct(register));
    }

    @CrossOrigin
    @GetMapping("/api/v1/sizes")
    public  ResponseEntity<?> sizeListApi() {
        return  ResponseEntity.ok().body(productService.getSizeListAll());
    }

    @CrossOrigin
    @GetMapping("/api/v1/colors")
    public  ResponseEntity<?> colorListApi() {
        return  ResponseEntity.ok().body(productService.getColorListAll());
    }

    @CrossOrigin
    @PostMapping("/api/v1/size")
    public ResponseEntity<?> registerSizeApi(@RequestBody ReqRegisterSizeDto reqRegisterSizeDto) {
        log.info("{}", reqRegisterSizeDto);
        return ResponseEntity.ok().body(productService.registerSize(reqRegisterSizeDto));
    }

    @CrossOrigin
    @PostMapping("/api/v1/color")
    public ResponseEntity<?> registerColorApi(@RequestBody ReqRegisterColorDto reqRegisterColorDto) {
        log.info("{}", reqRegisterColorDto);
        return ResponseEntity.ok().body(productService.registerColor(reqRegisterColorDto));
    }


}
