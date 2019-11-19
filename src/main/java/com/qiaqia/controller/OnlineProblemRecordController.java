package com.qiaqia.controller;


import com.qiaqia.dto.APIResponseDto;
import com.qiaqia.dto.PageAPIResponseDto;
import com.qiaqia.entity.OnlineProblemRecord;
import com.qiaqia.entity.QueryDto;
import com.qiaqia.service.OnlineProblemRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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
    public PageAPIResponseDto getRecordByCondition(@RequestParam int currentPage, @RequestBody QueryDto queryDto){
        PageAPIResponseDto dto = new PageAPIResponseDto();
        //设定每页条数
        int pageSize = 5;
        //获取查询结果的总条数
        int count = onlineProblemRecordService.getQueryCount(queryDto);
        //定义总页数
        int pageCount = 0;
        //计算当前查询出来的数据能分成几页
        if(count%pageSize==0){
            pageCount = count/pageSize;
        }else{
            pageCount = count/pageSize+1;
        }
        //判断当前页码和总页数的大小。另外，currentPage从0开始，表示第一页
        if(currentPage <= pageCount-1 && currentPage >=0) {
            List<OnlineProblemRecord> list = new ArrayList<OnlineProblemRecord>();
            int pageNum = currentPage * pageSize;
            try {
                list = onlineProblemRecordService.getRecordByCondition(pageNum,pageSize,queryDto);
                dto.setCode(0);
                dto.setMsg("请求成功");
                dto.setData(list);
                dto.setCurrentPage(currentPage);
                dto.setPageCount(pageCount);
                dto.setTotalCount(count);
            } catch (Exception e) {
                dto.setCode(-1);
                dto.setMsg("请求失败" + e.getMessage());
            }
        }else{
            dto.setCode(-1);
            dto.setCurrentPage(currentPage);
            dto.setPageCount(pageCount);
            dto.setTotalCount(count);
            dto.setMsg("请求页数不正确，请重新输入！");
        }
        return dto;
    }
}
