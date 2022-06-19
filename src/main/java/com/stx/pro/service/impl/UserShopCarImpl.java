package com.stx.pro.service.impl;

import com.stx.pro.mapper.UserShopCarMapper;
import com.stx.pro.service.UserShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年06月19日 12:26
 * @Description
 */
@Service
public class UserShopCarImpl implements UserShopCarService {
    @Autowired
    private UserShopCarMapper userShopCarMapper;
    @Override
    public List<com.stx.pro.vos.UserShopCar> queryUserShopCarList() {
        return userShopCarMapper.queryUserShopCarList();
    }
}
