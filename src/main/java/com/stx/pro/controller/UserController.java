package com.stx.pro.controller;

import com.stx.pro.pojo.User;
import com.stx.pro.utils.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author RenBoQing
 * @date 2022年06月02日 10:39
 * @Description 用户登录测试
 */
@Controller
public class UserController {
    /*
     *接口测试
     * @author RenBoQing
     * @date 2022/6/7 0007 16:37
     * @param user
     * @return com.stx.pro.utils.CommonResult<com.stx.pro.pojo.User>
     */
    @RequestMapping("/test")
    @ResponseBody
    public CommonResult<User> demo(User user) {
        user.setId(10L);
        user.setName("阮玲");
        return CommonResult.success(user);
    }
}
