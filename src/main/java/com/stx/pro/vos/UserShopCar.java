package com.stx.pro.vos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author RenBoQing
 * @date 2022年06月19日 12:17
 * @Description
 */
@Data
public class UserShopCar {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long uid;
    private String nickname;
    private String avatarurl;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long pid;
    private String pname;
    private double price;
    private String imgurl;
    private Integer number;
}
