package com.stx.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stx.pro.mapper.UserBehaviorMapper;
import com.stx.pro.service.UserBehaviorService;
import com.stx.pro.vos.UserBehaviorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserBehaviorImpl implements UserBehaviorService {
    @Autowired

    private UserBehaviorMapper userBehaviorMapper;
    @Override
    public List<UserBehaviorVo> queryAllUserBehaviorVo() {
        return userBehaviorMapper.queryAllUserBehaviorVo();
    }
}
