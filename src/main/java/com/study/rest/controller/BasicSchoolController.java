package com.study.rest.controller;

import com.study.rest.dto.ReqTeacherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@RestController
public class BasicSchoolController {

    @CrossOrigin
    @PostMapping("/basic/taecher")
    public ResponseEntity<?> schoolpost(@RequestBody ReqTeacherDto reqTeacherDto) {
        log.info("reqTecher : {}", reqTeacherDto);
        return ResponseEntity.ok().body(reqTeacherDto);
    }
}
