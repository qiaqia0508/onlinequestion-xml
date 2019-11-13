package com.qiaqia.dao;

import com.qiaqia.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface OnlineProblemRecordMapper {

//    根据条件查询
    List<OnlineProblemRecord> getRecordByCondition();
}
