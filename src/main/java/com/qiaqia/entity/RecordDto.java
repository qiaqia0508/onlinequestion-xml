package com.qiaqia.entity;

import lombok.Data;

import java.sql.Timestamp;

//插入操作记录时用到的entity
@Data
public class RecordDto {
    private Integer onlineProblemRecordId;//线上问题记录表id
    private Integer onlineProblemOperationType;//操作记录类型：1-新增，2-编辑，3-查看，4-查询，5-TL确认，6-PM确认，7-归档
    private Timestamp operationAt;//操作时间
    private String operationByName;//操作人名称

}
