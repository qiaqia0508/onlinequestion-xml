package com.qiaqia.dao;

import com.qiaqia.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Mapper
public interface OnlineProblemRecordMapper {

    OnlineProblemRecord queryById(String id);

//    根据条件查询
    List<OnlineProblemRecord> getRecordByCondition(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("queryDto") QueryDto queryDto);
//    获取查询总条数
    int getQueryCount(@Param("queryDto") QueryDto queryDto);

    boolean insertOrUpdate(@Param("onlineProblemRecord") OnlineProblemRecord onlineProblemRecord);

    List<OnlineProblemRecord> getAll(@Param("queryDto") QueryDto queryDto);
}
