package com.stx.pro.service.impl;

import com.stx.pro.mapper.UserOrderMapper;
import com.stx.pro.service.UserOrderService;
import com.stx.pro.vos.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年06月19日 14:42
 * @Description
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Autowired
    private UserOrderMapper userOrderMapper;
    @Override
    public List<UserOrderVo> queryUserOrder() {
        return userOrderMapper.queryUserOrder();
    }
}
