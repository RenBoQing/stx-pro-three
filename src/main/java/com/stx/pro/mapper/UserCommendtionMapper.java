package com.stx.pro.mapper;

import com.stx.pro.vos.UserCommendationVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserCommendtionMapper {
    List<UserCommendationVo> queryAllUserCommendtion();

}
