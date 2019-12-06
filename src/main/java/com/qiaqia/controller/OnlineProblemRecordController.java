package com.qiaqia.controller;


import com.qiaqia.dto.APIResponseDto;
import com.qiaqia.dto.PageAPIResponseDto;
import com.qiaqia.entity.OnlineProblemOperationRecord;
import com.qiaqia.entity.OnlineProblemRecord;
import com.qiaqia.entity.QueryDto;
import com.qiaqia.entity.RecordDto;
import com.qiaqia.service.OnlineProblemOperationRecordService;
import com.qiaqia.service.OnlineProblemRecordService;
import com.qiaqia.service.RedisLocalService;
import com.qiaqia.util.JSON;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    @Autowired
    OnlineProblemOperationRecordService onlineProblemOperationRecordService;
    @Autowired
    RedisLocalService redisLocalService;


    @ResponseBody
    @RequestMapping(path="/queryId",method = RequestMethod.GET)
    public APIResponseDto queryById(@RequestParam("id") String id){
        APIResponseDto dto = new APIResponseDto();
        OnlineProblemRecord record = new OnlineProblemRecord();

        //查询时先去redis查
        String hashKey = "record";
        String key = "id:"+id;
        //开始从redis中获取数据
        Object redisResult = redisLocalService.getHash(hashKey,key);
        if(redisResult==null){
            try{
                System.out.println("开始数据库查询");
                record = onlineProblemRecordService.queryById(id);
                dto.setCode(1);
                dto.setMsg("数据库获取数据成功");
                dto.setData(record);

                //往redis中添加数据
                System.out.println("开始往redis中写数据");
                String recordJson = JSON.serialize(record);
                redisLocalService.setHash(hashKey,key,recordJson);
//                redisLocalService.expire(key,60);
            }catch (Exception e){
                dto.setCode(-1);
                dto.setMsg("请求失败"+e.getMessage());
            }
        }else{
            //直接取redis中的内容进行返回
            System.out.println("开始redis查询");
            record = JSON.parse(redisResult.toString(),OnlineProblemRecord.class);
            dto.setCode(1);
            dto.setMsg("redis获取数据成功");
            dto.setData(record);
        }



        return dto;
    }


//    查询所有
    @ResponseBody
    @RequestMapping(path="/query",method = RequestMethod.POST)
    public PageAPIResponseDto getRecordByCondition(@RequestParam int currentPage,@RequestBody QueryDto queryDto){
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

//    新增操作
    @ResponseBody
    @RequestMapping(path = "/addOrEdit",method = RequestMethod.POST)
    public APIResponseDto insertOrUpdate(@RequestBody OnlineProblemRecord onlineProblemRecord){
        APIResponseDto dto = new APIResponseDto();
        RecordDto recordDto = new RecordDto();
        boolean flag = false;
        try{
            System.out.println("新增前的id："+onlineProblemRecord.getId());
            flag = onlineProblemRecordService.insertOrUpdate(onlineProblemRecord);
            System.out.println("新增后的id："+onlineProblemRecord.getId());
            if(flag) {
//                添加操作记录
                recordDto.setOnlineProblemRecordId(onlineProblemRecord.getId());
                recordDto.setOnlineProblemOperationType(1);
                recordDto.setOperationAt(onlineProblemRecord.getCreateAt());
                recordDto.setOperationByName(onlineProblemRecord.getCreateBy());
                boolean flag1 = onlineProblemOperationRecordService.addRecord(recordDto);
                if(flag1){
                    System.out.println("操作记录新增成功");
                }else{
                    System.out.println("操作记录新增失败");
                }
                dto.setCode(0);
                dto.setMsg("请求成功");
                dto.setData(flag);
            }
        }catch(Exception e){
            dto.setCode(-1);
            dto.setMsg("请求失败"+e.getMessage());
            dto.setData(flag);
        }
        return dto;
    }

//    导出
    @RequestMapping(path = "/export",method = RequestMethod.POST)
    public void exportExcel(HttpServletResponse response,@RequestBody QueryDto queryDto){
        HSSFWorkbook book = new HSSFWorkbook();
//        创建一个sheet并命名
        HSSFSheet sheet = book.createSheet("问题记录test001");
        try {
//            根据条件查询数据
            List<OnlineProblemRecord> record = onlineProblemRecordService.getAll(queryDto);
//            定义导出的文件名称
            String fileName = "online"+".xls";
//            新增数据行，设置单元格数据
            int rowNum = 1;
//            设置表头字段
            String[] headers = {"id","应用名称","问题描述","反馈人","反馈人工号","来源","城市"};
//            添加表头
            HSSFRow row = sheet.createRow(0);
//            在excel表中添加表头
            for(int i = 0;i<headers.length;i++){
                HSSFCell cell = row.createCell(i);
                HSSFRichTextString text  = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }
//          把查询获得的数据和表头一一对应
            for(OnlineProblemRecord onlineProblemRecord : record){
                HSSFRow row1 = sheet.createRow(rowNum);
                row1.createCell(0).setCellValue(onlineProblemRecord.getId());
                row1.createCell(1).setCellValue(onlineProblemRecord.getApp());
                row1.createCell(2).setCellValue(onlineProblemRecord.getProblemDesc());
                row1.createCell(3).setCellValue(onlineProblemRecord.getFeedbackManName());
                row1.createCell(4).setCellValue(onlineProblemRecord.getFeedbackManCode());
                row1.createCell(5).setCellValue(onlineProblemRecord.getSource());
                row1.createCell(6).setCellValue(onlineProblemRecord.getCityName());
                rowNum++;
            }

            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition","attachment;filename="+fileName);
            response.flushBuffer();
            book.write(response.getOutputStream());

        }catch(Exception e){
            e.printStackTrace();
        }

    }


}
