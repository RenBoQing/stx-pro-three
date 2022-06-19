package com.stx.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stx.pro.pojo.SysUserLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author RenBoQing
 * @date 2022年06月18日 16:12
 * @Description
 */
@Mapper
@Repository
public interface SysUserLogMapper  extends BaseMapper<SysUserLog> {

}
