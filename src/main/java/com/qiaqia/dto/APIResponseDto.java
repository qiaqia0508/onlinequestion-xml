package com.qiaqia.dto;

import lombok.Data;

@Data
public class APIResponseDto {

    //0表示成功，其他自定义
    int code = 0;

    String msg = "success";

    Object data;
}
