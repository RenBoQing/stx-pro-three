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
     *添加用户
     * @author RenBoQing
     * @date 2022/6/8 0008 8:34
     * @param user
     * @return int
     */
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

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
     *
     * @author RenBoQing
     * @date 2022/6/12 0012 14:11
     * @return java.util.List<com.stx.pro.pojo.User>
     */
    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public List<User> queryUserByTelNumber(String telnumber, String passwopd) {
        return userMapper.queryUserByTelNumber(telnumber, passwopd);
    }

    @Override
    public List<User> queryUserByEmail(String email, String password) {
        return userMapper.queryUserByEmail(email, password);
    }

    @Override
    public int delUserByUid(String uid) {
        long id = Long.parseLong(uid);
        return userMapper.deleteByUid(id);
    }
}


