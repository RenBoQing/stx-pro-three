package com.stx.pro.controller;

import com.stx.pro.pojo.User;
import com.stx.pro.service.UserService;
import com.stx.pro.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author RenBoQing
 * @date 2022年06月02日 10:39
 * @Description 用户控制器
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    /*
     * 微信用户注册
     * @author RenBoQing
     * @date 2022/6/8 0008 9:16
     * @param nickname
     * @param sex
     * @param avatarurl
     * @param password
     * @param telnumber
     * @param email
     * @return com.stx.pro.utils.CommonResult
     */
    @RequestMapping(value = "/wxUserRegister")
    @ResponseBody
    public CommonResult register(String nickname, Integer sex, String avatarurl, String password, String telnumber, String email) {
        User selectUserByTelNumber = userService.selectUserByTelNumber(telnumber);
        if (selectUserByTelNumber != null) {
            return CommonResult.failed("该用户已经注册，请直接登录");
        } else {
            User registerUser = new User();
            registerUser.setNickname(nickname);
            registerUser.setSex(sex);
            registerUser.setAvatarurl(avatarurl);
            registerUser.setPassword(password);
            registerUser.setTelnumber(telnumber);
            registerUser.setEmail(email);
            registerUser.setStatus(0);
            registerUser.setVgrade(2);
            registerUser.setVcount(100);
            userService.insert(registerUser);
            return CommonResult.success("注册成功");
        }
    }
}
