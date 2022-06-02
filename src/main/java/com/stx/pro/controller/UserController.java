package com.stx.pro.controller;

import com.stx.pro.pojo.User;
import com.stx.pro.utils.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author RenBoQing
 * @date 2022年06月02日 10:39
 * @Description  用户登录测试
 */
@Controller
public class UserController {
    @RequestMapping("/login")
    public CommonResult<User> demo(User user) {
        return CommonResult.success(user);
    }
}
