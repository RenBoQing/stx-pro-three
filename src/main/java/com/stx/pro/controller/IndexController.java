package com.stx.pro.controller;

import com.stx.pro.pojo.User;
import com.stx.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author RenBoQing
 * @date 2022年05月30日 15:21
 * @Description 页面默认处理Controller
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    /*
     *用户默认登录首页
     * @author RenBoQing
     * @date 2022/6/1 0001 14:12
     * @return java.lang.String
     */
    @RequestMapping("/index")
    public String index() {
        return "/login";
    }

    /*
     *登录跳转
     * @author RenBoQing
     * @date 2022/6/14 0014 10:40
     * @return java.lang.String
     */
    @RequestMapping("/adminIndex")
    public String demo() {
        return "/index";
    }

    /*
     *后台用户登录页面
     * @author RenBoQing
     * @date 2022/5/30 0030 15:42
     * @return java.lang.String
     */
    @RequestMapping("/adminLogin")
    public String login() {
        return "/login";
    }

    /*
     *后台系统总概述页面
     * @author RenBoQing
     * @date 2022/6/1 0001 20:41
     * @return java.lang.String
     */
    @RequestMapping("/summary")
    public String summary() {
        return "/summary";
    }

    /*
     *用户管理页面
     * @author RenBoQing
     * @date 2022/6/13 0013 9:02
     * @return java.lang.String
     */
    @RequestMapping("/user")
    public String user() {
        return "/user/user";
    }

    /*
     *用户修改页面
     * @author RenBoQing
     * @date 2022/6/14 0014 10:38
     * @param model
     * @param uid
     * @return java.lang.String
     */
    @RequestMapping("/user/queryUserByUid")
    public String queryUserByUid(Model model, Long uid) {
        User userlists = userService.getById(uid);
        model.addAttribute("userlists", userlists);
        return "/user/update";
    }

    /*
     *水果商评
     * @author RenBoQing
     * @date 2022/6/15 0015 9:43
     * @return java.lang.String
     */
    @RequestMapping("/mall/productlist")
    public String productListForWeb() {
        return "/mall/product";
    }

    @RequestMapping("/mall/addPage")
    public String productAdd() {
        return "/mall/add";
    }
}
