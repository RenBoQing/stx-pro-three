package com.stx.pro.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing
 * @date 2022年06月18日 15:54
 * @Description 管理员用户操作日志表
 */
@Data
@TableName("fruit_sys_log")
public class SysUserLog {
    @JsonFormat(shape = JsonFormat.Shape.STRING)   //解决雪花算法到前端进度丢失问题
    @TableId(value = "logsuid", type = IdType.ASSIGN_ID)  //数据库字段及设置问题
    private Long logsuid;
    private String title;
    private String description;
    private String operateurl;
    private String operateaddress;
    private Integer success;
    private String systemos;
    private Date createtime;
    private String browser;
    @JsonFormat(shape = JsonFormat.Shape.STRING)   //解决雪花算法到前端进度丢失问题
    @TableField("suid")
    private Long suid;
    private String sysnickname;
    private Integer deleted;
    private String clienttype;
}
