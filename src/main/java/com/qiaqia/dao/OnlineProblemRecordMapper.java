package com.qiaqia.dao;

import com.qiaqia.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

@Mapper
public interface OnlineProblemRecordMapper {

//    根据条件查询
    List<OnlineProblemRecord> getRecordByCondition(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize,@Param("queryDto") QueryDto queryDto);

//    获取查询总条数
    int getQueryCount(@Param("queryDto") QueryDto queryDto);

    boolean insertOrUpdate(@Param("onlineProblemRecord") OnlineProblemRecord onlineProblemRecord);

    List<OnlineProblemRecord> getAll(@Param("queryDto") QueryDto queryDto);
}
