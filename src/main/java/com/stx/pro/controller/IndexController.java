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

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
