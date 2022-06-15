package com.stx.pro.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * @author RenBoQing
 * @date 2022年06月14日 14:43
 * @Description 水果商品
 */
@Data
@TableName("fruit_product")
public class Product  implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)   //解决雪花算法到前端进度丢失问题
    @TableId(value = "pid", type = IdType.ASSIGN_ID)  //主键自增长
    private Long pid;
    private String pname;
    private double price;
    private Integer viewcount;
    private String imgurl;
    private String size;
    private double weight;
    private double heat;
    private double score;
    private String introduction;
    private String description;
    private Integer status;
    @TableLogic
    private Integer deleted;

}
