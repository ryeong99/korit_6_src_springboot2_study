package com.study.rest.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespGetListDto {
    private int computerId;
    private String company;
}
