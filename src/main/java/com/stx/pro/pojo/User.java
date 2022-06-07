package com.stx.pro.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author RenBoQing
 * @date 2022年05月30日 16:32
 * @Description 用户实体类
 */
@Data
@TableName("fruit_user")
public class User {
    private Long uid;
    private String nickname;
    private String password;
    private Integer sex;
    private String openid;
    private String avatarurl;
    private String telnumber;
    private String email;
    private Integer status;
    private Integer vgrade;
    @TableField("session_key")
    private String sessionKey;
}
