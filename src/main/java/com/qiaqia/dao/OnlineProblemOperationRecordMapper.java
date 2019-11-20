package com.qiaqia.dao;

import com.qiaqia.entity.RecordDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OnlineProblemOperationRecordMapper {
    boolean addRecord(RecordDto dto);
}
