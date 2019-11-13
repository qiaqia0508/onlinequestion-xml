package com.qiaqia.entity;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
public class OnlineProblemRecord {

    private Integer id;
    private Integer app;//应用：1-骑手app，2-商家app，3-鹰眼app，4-大中台
    private String problemDesc;//问题描述
    private String feedbackManName;//反馈人姓名
    private String feedbackManCode;//反馈人工号
    private String source;//来源
    private String cityName;//城市
    private String cityId;//城市id
    private Timestamp feedbackDate;//反馈时间
    private String resolveStatus;//解决状态:1-待解决，2-解决中,3-已解决
    private String productCode;//对接产品工号
    private String productName;//对接产品姓名
    private String engineerCode;//对接技术工号
    private String engineerName;//对接技术姓名
    private String dutyManCode;//责任人工号
    private String dutyManName;//责任人姓名
    private String problemReason;//问题原因
    private String problemType;//问题类型:1-操作问题,2-产品设计如此,3-第三方问题,4-故障,5-灰发,6-其他
    private String dealMethod;//处理方法
    private String remark;//备注
    private Timestamp createAt;//创建时间
    private String createBy;//创建人
    private Timestamp updateAt;//更新时间
    private String updateBy;//更新人
    private Integer isDeleted;//是否删除
    private Integer checkStatus;//工作流程状态：1-待TL审核，2-待PM审核，3-待归档，4-已归档

    @Override
    public String toString() {
        return "OnlineProblemRecord{" +
                "id=" + id +
                ", app=" + app +
                ", problemDesc='" + problemDesc + '\'' +
                ", feedbackManName='" + feedbackManName + '\'' +
                ", feedbackManCode='" + feedbackManCode + '\'' +
                ", source='" + source + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityId='" + cityId + '\'' +
                ", feedbackDate=" + feedbackDate +
                ", resolveStatus='" + resolveStatus + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", engineerCode='" + engineerCode + '\'' +
                ", engineerName='" + engineerName + '\'' +
                ", dutyManCode='" + dutyManCode + '\'' +
                ", dutyManName='" + dutyManName + '\'' +
                ", problemReason='" + problemReason + '\'' +
                ", problemType='" + problemType + '\'' +
                ", dealMethod='" + dealMethod + '\'' +
                ", remark='" + remark + '\'' +
                ", createAt=" + createAt +
                ", createBy='" + createBy + '\'' +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                ", isDeleted=" + isDeleted +
                ", checkStatus=" + checkStatus +
                '}';
    }
}
