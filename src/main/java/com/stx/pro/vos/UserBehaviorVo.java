package com.stx.pro.vos;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 实体类
 * @author ts
 * @date 2022/06/19
 */
@Data
public class UserBehaviorVo {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long uid;
    private Date time;
    private String btag;
    private Long goodsid;
    private String nickname;
    private int vgrade;
    private Date birthday;
    private Long pid;
    private String pname;
    private double price;
    @TableLogic
    private Integer deleted;
    //用户头像地址
    private String avatarurl;

}
