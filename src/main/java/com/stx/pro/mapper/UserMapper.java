package com.stx.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stx.pro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author RenBoQing
 * @date 2022年05月30日 16:23
 * @Description 用户实体类测试
 */
@Mapper
@Repository
public interface UserMapper  extends BaseMapper<User> {
}
