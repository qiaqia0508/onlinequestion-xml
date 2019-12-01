package com.qiaqia.service;

import com.qiaqia.dao.OnlineProblemOperationRecordMapper;
import com.qiaqia.entity.RecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnlineProblemOperationRecordService {
    @Autowired
    private OnlineProblemOperationRecordMapper onlineProblemOperationRecordMapper;

    public boolean addRecord(RecordDto dto ){
        return onlineProblemOperationRecordMapper.addRecord(dto);
    }
}
