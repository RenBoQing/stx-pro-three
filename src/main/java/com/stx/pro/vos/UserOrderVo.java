package com.stx.pro.vos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author RenBoQing
 * @date 2022年06月19日 14:36
 * @Description
 */
@Data
public class UserOrderVo {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orderid;
    private String nickname;
    private String avatarurl;
    private String pname;
    private String imgurl;
    private double price;
    private Integer number;
    private double sumprice;

}
