package com.study.rest.controller;

import com.study.rest.dto.ReqGetListDto;
import com.study.rest.dto.ReqRegisterComputerDto;
import com.study.rest.dto.ReqUpdateComputerDto;
import com.study.rest.service.ComputerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ComputerController {

    @Autowired
    private ComputerServiceImpl computerService;

    @PostMapping("/computer")
    public ResponseEntity<?> registerApi(@RequestBody ReqRegisterComputerDto reqDto)  {
        log.info("{}", reqDto);
        return  ResponseEntity.ok().body(computerService.registerComputer(reqDto));
    }
    @PutMapping("/computer/{computerId}")
    public ResponseEntity<?> modifyApi(@PathVariable int computerId, @RequestBody ReqUpdateComputerDto reqDto) {
        return  ResponseEntity.ok().body(computerService.updateComputer(reqDto));
    }
    @GetMapping("/computers")
    public ResponseEntity<?> getListApi(ReqGetListDto reqDto) {
        log.info("{}", reqDto);
        return  ResponseEntity.ok().body(computerService.getComputerList(reqDto));
    }
        public ResponseEntity<?> getApi() {
        return  ResponseEntity.ok().body(null);
    }
    @GetMapping("/computer/{computerId}")
    public ResponseEntity<?> getApi(@PathVariable int computerId) {
        log.info("{}",computerId);
        return ResponseEntity.ok().body(computerService.getComputer(computerId));
    }

    @DeleteMapping("/computer/{computerId}")
    public ResponseEntity<?> removeApi(@PathVariable int computerId) {
        return  ResponseEntity.ok().body(computerService.deleteComputer(computerId));
    }




}
