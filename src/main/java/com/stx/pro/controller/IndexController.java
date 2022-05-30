package com.stx.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author RenBoQing
 * @date 2022年05月30日 15:21
 * @Description 默认的设置
 */
@Controller
public class IndexController {
    /*
     *基础环境打通
     * @author RenBoQing
     * @date 2022/5/30 0030 15:42
     * @return java.lang.String
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
