package com.qiaqia.entity;

import lombok.Data;

import java.sql.Time;

@Data
public class OnlineProblemOperationRecord {
    private Integer id;//自增id
    private Integer onlineProblemRecordId;//线上问题记录表id
    private Integer onlineProblemOperationType;//操作记录类型：1-新增，2-编辑，3-查看，4-查询，5-TL确认，6-PM确认，7-归档
    private Time operationAt;//操作时间
    private String operationBy;//操作人名称



    @Override
    public String toString() {
        return "OnlineProblemOperationRecord{" +
                "id=" + id +
                ", onlineProblemRecordId=" + onlineProblemRecordId +
                ", onlineProblemOperationType=" + onlineProblemOperationType +
                ", operationAt=" + operationAt +
                ", operationBy='" + operationBy + '\'' +
                '}';
    }
}
