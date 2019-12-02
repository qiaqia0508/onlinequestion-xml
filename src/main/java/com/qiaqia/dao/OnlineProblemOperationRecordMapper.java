package com.qiaqia.dao;

import com.qiaqia.entity.RecordDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OnlineProblemOperationRecordMapper {
    boolean addRecord(@Param("dto") RecordDto dto);
}
