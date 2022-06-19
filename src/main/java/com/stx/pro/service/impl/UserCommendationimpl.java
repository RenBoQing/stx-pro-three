package com.stx.pro.service.impl;

import com.stx.pro.mapper.UserBehaviorMapper;
import com.stx.pro.mapper.UserCommendtionMapper;
import com.stx.pro.service.UserBehaviorService;
import com.stx.pro.service.UserCommendationService;
import com.stx.pro.vos.UserBehaviorVo;
import com.stx.pro.vos.UserCommendationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommendationimpl implements UserCommendationService {

    @Autowired
    private UserCommendtionMapper userCommendtionMapper;
    @Override
    public List<UserCommendationVo> queryAllUserCommendtion() {
        return userCommendtionMapper.queryAllUserCommendtion();
    }
}
