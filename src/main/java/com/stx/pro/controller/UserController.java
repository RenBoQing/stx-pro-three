package com.stx.pro.controller;

import com.stx.pro.pojo.User;
import com.stx.pro.service.UserService;
import com.stx.pro.utils.CommonResult;
import com.stx.pro.utils.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    /*
     *查询所有的用户
     * @author RenBoQing
     * @date 2022/6/10 0010 10:02
     * @return com.stx.pro.utils.JsonObject
     */
    @RequestMapping(value = "/userList")
    @ResponseBody
    public JsonObject result() {
        List<User> userList = userService.selectAllUsers();
        return JsonObject.success(0, userList, "查询成功", (long) userList.size());
    }

    /*
     *使用电话号码登录
     * @author RenBoQing
     * @date 2022/6/12 0012 11:07
     * @param telnumber
     * @param password
     * @return com.stx.pro.utils.JsonObject
     */
    @RequestMapping(value = "/loginByTelNumber/{telnumber}/{password}")
    @ResponseBody
    public JsonObject loginByTelNumber(@PathVariable("telnumber") String telnumber, @PathVariable("password") String password) {
        List<User> userList = userService.queryUserByTelNumber(telnumber, password);
        if (userList.size() > 0) {
            return JsonObject.success(0, userList, "查询成功", (long) userList.size());
        } else {
            return JsonObject.fail(1, "用户名或密码错误");
        }
    }

    /*
     *使用邮箱登录
     * @author RenBoQing
     * @date 2022/6/12 0012 11:07
     * @param email
     * @param password
     * @return com.stx.pro.utils.JsonObject
     */
    @RequestMapping(value = "/loginByEmail/{email}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject loginByEmail(@PathVariable("email") String email, @PathVariable("password") String password) {
        List<User> userList = userService.queryUserByEmail(email, password);
        if (userList.size() > 0) {
            return JsonObject.success(0, userList, "查询成功", (long) userList.size());
        } else {
            return JsonObject.fail(1, "用户名或密码错误");
        }
    }
    @RequestMapping("/del/{uid}")
    @ResponseBody
    public JsonObject delUserByUid(@PathVariable("uid") String uid){
       int result= userService.delUserByUid(uid);
         if(result>0){
             return JsonObject.success(0,"删除成功");
         }
         else {
             return JsonObject.fail(1,"删除失败");
         }
    }
}

