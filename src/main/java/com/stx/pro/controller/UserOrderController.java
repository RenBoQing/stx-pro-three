package com.stx.pro.controller;

import com.stx.pro.service.UserOrderService;
import com.stx.pro.utils.JsonObject;
import com.stx.pro.vos.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年06月19日 14:43
 * @Description
 */
@Controller
@RequestMapping("/userOrders")
public class UserOrderController {
    @Autowired
    private UserOrderService orderService;
    @RequestMapping("/userOrderList")
    @ResponseBody
    public JsonObject queryUserOrderList() {
        List<UserOrderVo> orderVos = orderService.queryUserOrder();
        if (orderVos.size() > 0) {
            return JsonObject.success(0, orderVos, "查询成功", (long) orderVos.size());
        } else {
            return JsonObject.fail(1, "暂无数据");
        }
    }
}
