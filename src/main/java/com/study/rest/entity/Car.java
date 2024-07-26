package com.study.rest.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Car {
    private String model;
    private String color;
}
