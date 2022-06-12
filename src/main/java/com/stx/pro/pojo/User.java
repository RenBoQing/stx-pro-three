package com.stx.pro.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    @TableId(value = "uid", type = IdType.ASSIGN_ID)
    private Long uid;

    private String nickname;
    private String password;
    private Integer sex;
    private String avatarurl;
    private String telnumber;
    private String email;
    private Integer status;
    private Integer vgrade;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer vcount;
}
