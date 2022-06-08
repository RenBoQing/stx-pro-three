package com.stx.pro.controller;

import com.stx.pro.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author RenBoQing
 * @date 2022年05月30日 15:21
 * @Description 默认的Controller
 */
@Controller
public class IndexController {

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
    @RequestMapping("/admindSummary")
    public String summary() {
        return "/summary";
    }
}
