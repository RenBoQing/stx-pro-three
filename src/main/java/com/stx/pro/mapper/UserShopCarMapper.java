package com.stx.pro.mapper;

import com.stx.pro.vos.UserShopCar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年06月19日 12:22
 * @Description
 */
@Mapper
@Repository
public interface UserShopCarMapper {
    List<UserShopCar> queryUserShopCarList();
}
