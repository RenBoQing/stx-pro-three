package com.stx.pro.controller;

import com.stx.pro.pojo.Comment;
import com.stx.pro.pojo.SysUser;
import com.stx.pro.pojo.SysUserLog;
import com.stx.pro.service.SysUserLogService;
import com.stx.pro.service.UserBehaviorService;
import com.stx.pro.utils.BrowserUtils;
import com.stx.pro.utils.CommonResult;
import com.stx.pro.utils.JsonObject;
import com.stx.pro.vos.SysUserDeptVo;
import com.stx.pro.vos.UserBehaviorVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/userBehavior")
@Slf4j
public class UserBehaviorController {

    @Autowired
    private UserBehaviorService userBehaviorService;
     /*
      *查询用户的所有行为
      * @author RenBoQing
      * @date 2022/7/24 0024 21:42
      * @return com.stx.pro.utils.JsonObject
      */
    @ResponseBody
    @RequestMapping(value = "/userBehaviorList")
    public JsonObject queryAllUserBehaviorVo() {
        List<UserBehaviorVo> userBehaviorVos = userBehaviorService.queryAllUserBehaviorVo();
        if (userBehaviorVos.size() > 0) {
            return JsonObject.success(0,userBehaviorVos,"查询成功", (long) userBehaviorVos.size());
        } else {
            return JsonObject.fail("暂无数据");
        }
    }
}
