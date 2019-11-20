package com.qiaqia.service;

import com.qiaqia.dao.OnlineProblemRecordMapper;
import com.qiaqia.entity.OnlineProblemRecord;
import com.qiaqia.entity.QueryDto;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OnlineProblemRecordService {

    @Autowired
    OnlineProblemRecordMapper onlineProblemRecordMapper;

    public List<OnlineProblemRecord> getRecordByCondition(int pageNum, int pageSize, QueryDto queryDto){
        List<OnlineProblemRecord> list = new ArrayList<OnlineProblemRecord>();
        list = onlineProblemRecordMapper.getRecordByCondition(pageNum,pageSize,queryDto);
        return list;
    }

    public int getQueryCount(QueryDto queryDto){
        return onlineProblemRecordMapper.getQueryCount(queryDto);
    }

    public boolean insertOrUpdate(OnlineProblemRecord onlineProblemRecord){
        return onlineProblemRecordMapper.insertOrUpdate(onlineProblemRecord);
    }

    public List<OnlineProblemRecord> getAll(QueryDto queryDto){
        return onlineProblemRecordMapper.getAll(queryDto);
    }


}
