package com.stx.pro.controller;

import com.stx.pro.pojo.SysUserLog;
import com.stx.pro.service.SysUserLogService;
import com.stx.pro.utils.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年06月18日 16:20
 * @Description 用户日志横向切入
 */
@Controller
@RequestMapping("/sysUserLogs")
public class SysUserLogController {
    @Autowired
    private SysUserLogService sysUserLogService;
     @RequestMapping("/SysUserLogList")
     @ResponseBody
    public JsonObject  querySysUserLog(){
        List<SysUserLog> list = sysUserLogService.list();
        if(list.size()>0){
            return JsonObject.success(0,list,"查询成功", (long) list.size());
        }
        else {
            return JsonObject.fail(1,"暂无数据");
        }
    }
}
