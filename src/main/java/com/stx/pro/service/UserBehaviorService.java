package com.stx.pro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stx.pro.vos.SysUserDeptVo;
import com.stx.pro.vos.UserBehaviorVo;

import java.util.List;

public interface UserBehaviorService  {
    List<UserBehaviorVo>  queryAllUserBehaviorVo();
}
