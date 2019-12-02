package com.qiaqia.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class QueryDto {

    int id;
    int app;
    String problemReason;
    int resolveStatus;
    Timestamp date;
    int checkStatus;
}
