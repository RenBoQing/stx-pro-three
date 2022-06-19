package com.stx.pro.service;

import com.stx.pro.vos.UserOrderVo;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年06月19日 14:42
 * @Description
 */
public interface UserOrderService {
    List<UserOrderVo> queryUserOrder();
}
