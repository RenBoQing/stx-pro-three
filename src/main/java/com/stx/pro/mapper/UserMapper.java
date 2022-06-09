package com.stx.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stx.pro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年05月30日 16:23
 * @Description  用户接口
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


    List<User> selectAllUsers();
}
