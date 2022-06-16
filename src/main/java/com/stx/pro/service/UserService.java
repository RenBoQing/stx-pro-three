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
     *根据电话查询用户
     * @author RenBoQing
     * @date 2022/6/8 0008 8:33
     * @param openid
     * @return com.stx.pro.pojo.User
     */
    User selectUserByTelNumber(String telnumber);

    /*
     *通过电话登录
     * @author RenBoQing
     * @date 2022/6/16 0016 11:04
     * @param telnumber
     * @param password
     * @return java.util.List<com.stx.pro.pojo.User>
     */
    List<User> queryUserByTelNumber(String telnumber, String password);

    /*
     *通过邮箱登录
     * @author RenBoQing
     * @date 2022/6/16 0016 11:05
     * @param email
     * @param password
     * @return java.util.List<com.stx.pro.pojo.User>
     */
    List<User> queryUserByEmail(String email, String password);


}
