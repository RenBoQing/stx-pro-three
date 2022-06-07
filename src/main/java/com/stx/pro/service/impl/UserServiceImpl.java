package com.stx.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stx.pro.mapper.UserMapper;
import com.stx.pro.pojo.User;
import com.stx.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author RenBoQing
 * @date 2022年06月07日 20:26
 * @Description 用户实体类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User selectUserByOpenId(String openid) {
        return userMapper.selectUserByOpenId(openid);
    }
}


