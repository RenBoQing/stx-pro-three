package com.stx.pro.controller;

import com.stx.pro.service.UserCommendationService;
import com.stx.pro.utils.JsonObject;
import com.stx.pro.vos.UserCommendationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/userCommendtion")
@Slf4j
public class UserCommendtionController {
    @Autowired
    private UserCommendationService userCommendationService;
    @ResponseBody
    @RequestMapping(value = "/userCommendtionList")
    public JsonObject queryAllUserCommendtion(){
        List<UserCommendationVo> userCommendations=userCommendationService.queryAllUserCommendtion();
        if (userCommendations.size()>0){
            return JsonObject.success(0,userCommendations,"查询成功", (long) userCommendations.size());
        } else {
            return JsonObject.fail("暂无数据");
        }
    }
}
