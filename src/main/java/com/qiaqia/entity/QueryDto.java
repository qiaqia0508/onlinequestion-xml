package com.qiaqia.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;

@Data
public class QueryDto {

    int id;
    int app;
    String problemReason;
    int resolveStatus;
    Date date;
    int checkStatus;
}
