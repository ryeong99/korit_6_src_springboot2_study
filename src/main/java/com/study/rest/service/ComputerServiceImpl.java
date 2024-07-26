package com.study.rest.service;

import com.study.rest.dto.ReqUpdateComputerDto;
import com.study.rest.dto.ResqGetComputerDto;
import com.study.rest.dto.ReqGetListDto;
import com.study.rest.dto.ReqRegisterComputerDto;
import com.study.rest.entity.Computer;
import com.study.rest.entity.RespGetListDto;
import com.study.rest.repository.ComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComputerServiceImpl {

    @Autowired
    private ComputerMapper computerMapper;

    public int registerComputer(ReqRegisterComputerDto reqDto) {
        Computer computer = Computer.builder()
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .ram(reqDto.getRam())
                .ssd(reqDto.getSsd())
                .build();
        return computerMapper.save(computer);
    }

    public List<RespGetListDto> getComputerList(ReqGetListDto reqDto) {
        List<RespGetListDto> respDtos = new ArrayList<>();
        Computer computer = Computer.builder()
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .build();
        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(computer);
        System.out.println(reqDto);
        return computers.stream().map(com -> RespGetListDto.builder()
                .computerId(com.getComputerId())
                .company(com.getCompany())
                .build()
        ).collect(Collectors.toList());
    }

    public ResqGetComputerDto getComputer(int computerId) {
        Computer computer = computerMapper.findComputerById(computerId);
        return ResqGetComputerDto.builder()
                .computerId(computer.getComputerId())
                .company(computer.getCompany())
                .cpu(computer.getCpu())
                .ram(computer.getRam())
                .ssd(computer.getSsd())
                .build();
    }

    public int deleteComputer(int computerId) {
        return computerMapper.delete(computerId);
    }

    public  int updateComputer(ReqUpdateComputerDto reqDto) {
        Computer computer = Computer.builder()
                .computerId(reqDto.getComputerId())
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .ram(reqDto.getRam())
                .ram(reqDto.getRam())
                .build();

        return computerMapper.update(computer);
    }
}

//public List<RespGetListDto> getComputerList(ReqGetListDto reqDto) {
//    List<RespGetListDto> respDtos = new ArrayList<>();
//    Computer computer = Computer.builder()
//            .company(reqDto.getCompany())
//            .cpu(reqDto.getCpu())
//            .build();
//    List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(computer);
//
//    for (Computer com : computers ) {
//        RespGetListDto dto = RespGetListDto.builder()
//                .computerId(com.getComputerId())
//                .company(com.getCompany())
//                .build();
//
//        respDtos.add(dto);
//    }
//
//    return respDtos;
//}
//}