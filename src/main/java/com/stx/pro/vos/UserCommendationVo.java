package com.stx.pro.vos;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class UserCommendationVo {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String nickname;
    private String sex;
    private int vgrade;
    private Long uid;
    @TableLogic
    private Integer deleted;
    private String avatarurl;

}
