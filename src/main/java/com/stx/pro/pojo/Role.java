package com.stx.pro.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing
 * @date 2022年06月17日 17:30
 * @Description
 */
@Data
@TableName("fruit_role")
public class Role {
    @JsonFormat(shape = JsonFormat.Shape.STRING)   //解决雪花算法到前端进度丢失问题
    @TableId(value = "rid", type = IdType.ASSIGN_ID)
    private Long rid;//主键自增长
    @TableField("rolename")
    private String roleName;
    private String description;
    @TableField("createtime")
    private Date createTime;
    @TableField("updatetime")
    private Date updateTime;
    @TableField("datascope")
    private String dataScope;
    @TableLogic
    private Integer deleted;
}
