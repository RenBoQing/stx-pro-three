package com.stx.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stx.pro.vos.UserBehaviorVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface UserBehaviorMapper  {
       List<UserBehaviorVo>  queryAllUserBehaviorVo();

}
