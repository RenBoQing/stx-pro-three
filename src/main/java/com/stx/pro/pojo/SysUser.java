package com.stx.pro.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("fruit_sysuser")
public class SysUser {
    @JsonFormat(shape = JsonFormat.Shape.STRING)   //解决雪花算法到前端进度丢失问题
    @TableId(value = "suid", type = IdType.ASSIGN_ID)  //数据库字段及设置问题
    private Long suid;
    private String sysnickname;
    private String syspassword;
    private String sysemail;
    private Integer systatus;
    private Date createtime;
    private Date updatetime;
    private Integer deptid;
    private String sysname;
    @TableLogic
    private Integer deleted;
}
