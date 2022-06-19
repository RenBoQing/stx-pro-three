package com.stx.pro.controller;

import com.stx.pro.service.SysUserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author RenBoQing
 * @date 2022年06月18日 16:20
 * @Description 用户日志横向切入
 */
@Controller
@RequestMapping("/sysUserLog")
public class SysUserLogController {
    @Autowired
    private SysUserLogService sysUserLogService;

}
