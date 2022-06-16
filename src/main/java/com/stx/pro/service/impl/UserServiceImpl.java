package com.stx.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stx.pro.mapper.UserMapper;
import com.stx.pro.pojo.User;
import com.stx.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年06月07日 20:26
 * @Description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;



    /*
     *根据电话查询用户
     * @author RenBoQing
     * @date 2022/6/8 0008 9:19
     * @param telnumber
     * @return com.stx.pro.pojo.User
     */
    @Override
    public User selectUserByTelNumber(String telnumber) {
        return userMapper.selectUserByTelNumber(telnumber);
    }
    /*
     *根据
     * @author RenBoQing
     * @date 2022/6/14 0014 21:57
     * @param telnumber
     * @param passwopd
     * @return java.util.List<com.stx.pro.pojo.User>
     */
    @Override
    public List<User> queryUserByTelNumber(String telnumber, String passwopd) {
        return userMapper.queryUserByTelNumber(telnumber, passwopd);
    }
    @Override
    public List<User> queryUserByEmail(String email, String password) {
        return userMapper.queryUserByEmail(email, password);
    }

}


