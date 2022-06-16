package com.stx.pro.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 评论
 * @author ts
 * @date 2022/06/16
 */
@Data
@TableName("goods_comment")
public class Comment {
    @JsonFormat(shape = JsonFormat.Shape.STRING)   //解决雪花算法到前端进度丢失问题
    @TableId(value = "cid", type = IdType.ASSIGN_ID)
    private Long cid;
    private Long uid;
    private String content;
    private Date createtime;
    private Long pid;
    @TableLogic
    private Integer deleted;


}
