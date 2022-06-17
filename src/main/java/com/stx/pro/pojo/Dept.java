package com.stx.pro.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author RenBoQing
 * @date 2022年06月17日 18:53
 * @Description
 */
@Data
@TableName("fruit_dept")
public class Dept {
    @JsonFormat(shape = JsonFormat.Shape.STRING)   //解决雪花算法到前端进度丢失问题
    @TableId(value = "pid", type = IdType.ASSIGN_ID)  //主键自增长
    private Long deptId;
    private Long parentId;
    @TableField("deptname")
    private String deptName;
    private Integer sort;
    private Integer status;
    @TableField("createtime")
    private Date createTime;
    @TableLogic
    private Integer deleted;
}
