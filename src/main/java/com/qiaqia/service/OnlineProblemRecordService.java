package com.qiaqia.service;

import com.qiaqia.dao.OnlineProblemRecordMapper;
import com.qiaqia.entity.OnlineProblemRecord;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OnlineProblemRecordService {

    @Autowired
    OnlineProblemRecordMapper onlineProblemRecordMapper;

    public List<OnlineProblemRecord> getRecordByCondition(){
        List<OnlineProblemRecord> list = new ArrayList<OnlineProblemRecord>();
        list = onlineProblemRecordMapper.getRecordByCondition();
        return list;
    }
}
