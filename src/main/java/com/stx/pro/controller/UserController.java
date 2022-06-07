package com.stx.pro.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stx.pro.pojo.User;
import com.stx.pro.service.UserService;
import com.stx.pro.utils.CommonResult;
import com.stx.pro.utils.JsonObject;
import com.stx.pro.utils.WxOpenIdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author RenBoQing
 * @date 2022年06月02日 10:39
 * @Description 用戶
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/register")
    @ResponseBody
    public CommonResult register(String demo, String nickname, Integer sex, String avatarurl, String password, String telnumber, String email) {
        //微信官方提供获取openid的url
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JS_CODE&grant_type=authorization_code";
        //替换appid，appsecret，和code
        String requestUrl = WX_URL.replace("APPID", "wxcda84cfe03f87b7b").//填写自己的appid
                replace("SECRET", "c8320b4c4faba1fda9d1f88424819d40").replace("JS_CODE", demo).//填写自己的appsecret，
                replace("authorization_code", "authorization_code");
        //定义json对象
        JSONObject convertvalue = new JSONObject();
        //调用get方法
        String returnvalue = WxOpenIdUtils.GET(requestUrl);
        //解析返回值，对象解析成字符串
        convertvalue = (JSONObject) JSON.parse(returnvalue);
        String session_key = (String) convertvalue.get("session_key");
        String openid = (String) convertvalue.get("openid");
        User registerUser = userService.selectUserByOpenId(openid);//判断数据库中是否已存在
        if (registerUser == null) {
            User user = new User();
            user.setSex(sex);
            user.setOpenid(openid);
            user.setAvatarurl(avatarurl);
            user.setNickname(nickname);
            user.setPassword(password);
            user.setTelnumber(telnumber);
            user.setEmail(email);
            user.setSessionKey(session_key);
            user.setStatus(0);
            user.setVgrade(1);
            userService.insert(user);
        } else {
            return CommonResult.failed("该用户已经存在");
        }
        return CommonResult.success("请求成功","注册成功");
    }
}
