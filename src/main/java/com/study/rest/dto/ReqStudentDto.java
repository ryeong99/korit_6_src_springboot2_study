package com.study.rest.dto;

import lombok.Data;
import lombok.ToString;

@Data
public class ReqStudentDto {
    private String schoolName;
    private String department;
    private int grade;
    private String name;
}
