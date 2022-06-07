package com.stx.pro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stx.pro.pojo.User;

/**
 * @author RenBoQing
 * @date 2022年06月07日 20:25
 * @Description
 */
public interface UserService extends IService<User> {
    int insert(User user);
    User selectUserByOpenId(String openid);
}
