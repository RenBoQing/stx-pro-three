package com.stx.pro.controller;

import com.stx.pro.service.UserShopCarService;
import com.stx.pro.utils.JsonObject;
import com.stx.pro.vos.UserShopCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年06月19日 12:27
 * @Description
 */
@Controller
@RequestMapping("/userShopCars")
public class UserShopCarController {
    @Autowired
    private UserShopCarService userShopCarService;

    /*
     *查询所有用户的购物车
     * @author RenBoQing
     * @date 2022/6/19 0019 12:43
     * @return com.stx.pro.utils.JsonObject
     */
    @RequestMapping("/shopCarList")
    @ResponseBody
    public JsonObject queryAllShopCar() {
        List<UserShopCar> userShopCars = userShopCarService.queryUserShopCarList();
        if (userShopCars.size() > 0) {
            return JsonObject.success(0, userShopCars, "查询成功", (long) userShopCars.size());
        } else {
            return JsonObject.fail(1, "暂无数据");
        }
    }
}
