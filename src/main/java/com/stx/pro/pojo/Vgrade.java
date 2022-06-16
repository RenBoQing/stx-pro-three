package com.stx.pro.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author RenBoQing
 * @date 2022年06月08日 10:21
 * @Description 会员等级
 */
@Data
@TableName("fruit_vgrade")
public class Vgrade {
     @TableId("vid")
    private Long vid;   //会员id
    private String vname; //会员名称
    private Integer vcount; //会员积分
}
