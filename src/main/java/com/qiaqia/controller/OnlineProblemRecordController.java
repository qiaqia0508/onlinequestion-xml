package com.qiaqia.controller;


import com.qiaqia.dto.APIResponseDto;
import com.qiaqia.entity.OnlineProblemRecord;
import com.qiaqia.service.OnlineProblemRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping(path="/online")
public class OnlineProblemRecordController {

    @Autowired
    OnlineProblemRecordService onlineProblemRecordService;

//    查询所有
    @ResponseBody
    @RequestMapping(path="/query",method = RequestMethod.POST)
    public APIResponseDto getRecordByCondition(){
        APIResponseDto dto = new APIResponseDto();
        List<OnlineProblemRecord> list = new ArrayList<OnlineProblemRecord>();
        try{
            list = onlineProblemRecordService.getRecordByCondition();
            dto.setCode(0);
            dto.setMsg("请求成功");
            dto.setData(list);
        }catch (Exception e){
            dto.setCode(-1);
            dto.setMsg("请求失败"+e.getMessage());
        }
        return dto;
    }
}
