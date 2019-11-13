package com.qiaqia.entity;

import lombok.Data;

@Data
public class OnlineProblemRole {
    private Integer id;//自增id
    private Integer roleId;//业务使用id
    private String roleName;//角色名称
    private String roleList;//工号列表


    @Override
    public String toString() {
        return "OnlineProblemRole{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleList='" + roleList + '\'' +
                '}';
    }
}
