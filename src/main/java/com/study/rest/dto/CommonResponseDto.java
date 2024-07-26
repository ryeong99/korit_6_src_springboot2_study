package com.study.rest.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommonResponseDto {

        private String message;
        private int count;
        private boolean isSuccess;

        public static CommonResponseDto ofDefault(int count) {
            return CommonResponseDto.builder()
                    .message(count > 0 ? "successfully" : "Failed")
                    .count(count)
                    .isSuccess(count > 0)
                    .build();
        }
}
