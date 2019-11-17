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

    public List<OnlineProblemRecord> getRecordByCondition(int pageNum, int pageSize){
        List<OnlineProblemRecord> list = new ArrayList<OnlineProblemRecord>();
        list = onlineProblemRecordMapper.getRecordByCondition(pageNum,pageSize);
        return list;
    }

    public int getQueryCount(){
        return onlineProblemRecordMapper.getQueryCount();
    }
}
