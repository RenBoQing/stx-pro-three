package com.stx.pro.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author RenBoQing
 * @date 2022年05月30日 16:32
 * @Description 用户实体类
 */
@Data
@TableName("fruit_user")
public class User {
    @JsonFormat(shape = JsonFormat.Shape.STRING)   //解决雪花算法到前端进度丢失问题
    @TableId(value = "uid", type = IdType.ASSIGN_ID)  //主键自增长
    private Long uid;
    private String nickname;
    private String password;
    private Integer sex;
    private String avatarurl;
    private String telnumber;
    private String email;
    private Integer status;
    private Integer vgrade;
    @DateTimeFormat(pattern = "yyyy-MM-dd")  //时间日期格式化
    private Date birthday;
    private Integer vcount;    //会员积分数
    @TableLogic
    private Integer deleted;   //mybatis-plus逻辑删除
}
