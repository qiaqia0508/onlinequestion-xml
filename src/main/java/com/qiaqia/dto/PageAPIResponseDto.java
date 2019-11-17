package com.qiaqia.dto;

import lombok.Data;

@Data
public class PageAPIResponseDto extends APIResponseDto{
    //定义分页用的参数
    int currentPage = 0;//当前页码

    int totalCount = 0;//总条数

    int pageSize = 5;//每页条数

    int pageCount = 0;//页数
}
