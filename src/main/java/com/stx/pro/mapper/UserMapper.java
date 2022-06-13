package com.stx.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stx.pro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年05月30日 16:23
 * @Description 用户操作接口
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    /*
     *根据openid查询用户
     * @author RenBoQing
     * @date 2022/6/7 0007 20:54
     * @param openid
     * @return com.stx.pro.pojo.User
     */
    User selectUserByTelNumber(String telnumber);

    /*
     *查询所有的用户
     * @author RenBoQing
     * @date 2022/6/12 0012 14:09
     * @return java.util.List<com.stx.pro.pojo.User>
     */

    /*
     * 电话号码登录
     * @author RenBoQing
     * @date 2022/6/12 0012 14:09
     * @param telnumber
     * @param password
     * @return java.util.List<com.stx.pro.pojo.User>
     */
    List<User> queryUserByTelNumber(String telnumber, String password);

    /*
     *邮箱登录
     * @author RenBoQing
     * @date 2022/6/12 0012 14:09
     * @param email
     * @param password
     * @return java.util.List<com.stx.pro.pojo.User>
     */
    List<User> queryUserByEmail(String email, String password);

}