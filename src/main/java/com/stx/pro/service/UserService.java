package com.stx.pro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stx.pro.pojo.User;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年06月07日 20:25
 * @Description
 */
public interface UserService extends IService<User> {
    /*
     *添加用户
     * @author RenBoQing
     * @date 2022/6/8 0008 8:33
     * @param user
     * @return int
     */
    int insert(User user);
    /*
     *根据openid查询用户
     * @author RenBoQing
     * @date 2022/6/8 0008 8:33
     * @param openid
     * @return com.stx.pro.pojo.User
     */
    User selectUserByTelNumber(String telnumber);


    List<User> selectAllUsers();
    List<User> queryUserByTelNumber(String telnumber,String password);

    List<User> queryUserByEmail(String email, String password);

    int delUserByUid(String uid);
}
