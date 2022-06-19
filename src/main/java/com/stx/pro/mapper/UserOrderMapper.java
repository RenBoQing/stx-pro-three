package com.stx.pro.mapper;

import com.stx.pro.vos.UserOrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年06月19日 13:54
 * @Description
 */
@Mapper
@Repository
public interface UserOrderMapper {
    List<UserOrderVo> queryUserOrder();
}
