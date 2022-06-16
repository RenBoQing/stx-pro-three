package com.stx.pro.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stx.pro.pojo.User;
import com.stx.pro.service.UserService;
import com.stx.pro.utils.CommonResult;
import com.stx.pro.utils.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
    public CommonResult register(@PathVariable("nickname") @RequestParam(defaultValue = "测试数据") String nickname, Integer sex, String avatarurl, String password, String telnumber, String email, @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday) {
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
            registerUser.setBirthday(birthday);
            userService.save(registerUser);
            return CommonResult.success("注册成功");
        }
    }
    /*
     *查询所有的用户
     * @author RenBoQing
     * @date 2022/6/10 0010 10:02
     * @return com.stx.pro.utils.JsonObject
     */
    @RequestMapping("/userList")
    @ResponseBody
    public JsonObject result(User user, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        List<User> list = userService.list();
        return JsonObject.success(0,list, "查询成功", (long) list.size());
    }

    /*
     *模糊查询
     * @author RenBoQing
     * @date 2022/6/14 0014 9:54
     * @param user
     * @param page
     * @param limit
     * @return com.stx.pro.utils.CommonResult
     */
    @RequestMapping("/userListForWx")
    @ResponseBody
    public CommonResult resultdemo(User user, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        Page<User> useInfoPage = userService.page(new Page<>(page, limit), Wrappers.<User>lambdaQuery().
                orderByDesc(User::getUid).like(StringUtils.isNotEmpty(user.getNickname()), User::getNickname, user.getNickname())
                .like(StringUtils.isNotBlank(user.getTelnumber()), User::getTelnumber, user.getTelnumber()).
                        like(StringUtils.isNotBlank(user.getEmail()), User::getEmail, user.getEmail()));
        return CommonResult.success(useInfoPage, "查询成功");
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
            return JsonObject.success(0, userList, "登录成功", (long) userList.size());
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
    @RequestMapping(value = "/loginByEmail/{email}/{password}", method = RequestMethod.POST)
    @ResponseBody
    public JsonObject loginByEmail(@PathVariable("email") String email, @PathVariable("password") String password) {
        List<User> userList = userService.queryUserByEmail(email, password);
        if (userList.size() > 0) {
            return JsonObject.success(0, userList, "登录成功", (long) userList.size());
        } else {
            return JsonObject.fail(1, "用户名或密码错误");
        }
    }

    /*
     *删除数据
     * @author RenBoQing
     * @date 2022/6/12 0012 17:31
     * @param uid
     * @return com.stx.pro.utils.JsonObject
     */
    @RequestMapping(value = "/del/{uid}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonObject deleteUserByUid(@PathVariable("uid") Long uid) {
        boolean b = userService.removeById(uid);
        if (b) {
            return JsonObject.success(0, "删除成功");
        } else {
            return JsonObject.fail(1, "删除失败");
        }
    }

    /*
     *批量删除
     * @author RenBoQing
     * @date 2022/6/12 0012 17:30
     * @param ids
     * @return com.stx.pro.utils.CommonResult
     */
    @RequestMapping(value = "/delUserByIds", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult delUserByIds(String ids) {
        //将获取到的ids的数组进行分割
        String[] strs = ids.split(",");
        List<Long> delList = new ArrayList<>();
        //遍历这些ids 并将其添加到List集合中
        for (String str : strs) {
            delList.add(Long.parseLong(str));
        }
        //是否删除成功
        boolean b = userService.removeByIds(delList);
        if (b) {
            return CommonResult.success("删除成功");
        } else {
            return CommonResult.failed("删除失败");
        }
    }

    /*
     *修改用户信息
     * @author RenBoQing
     * @date 2022/6/13 0013 22:07
     * @return com.stx.pro.utils.CommonResult
     */
    @RequestMapping(value = "/updateByUid", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateByUid(User user) {
        boolean updateById = userService.updateById(user);
        if (updateById) {
            return CommonResult.success("修改成功");
        } else {
            return CommonResult.failed("修改失败");
        }
    }
}

