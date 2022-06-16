package com.stx.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stx.pro.pojo.SysUser;
import com.stx.pro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {


    List<SysUser> queryAllSysUser(String sysemail);

    /**
     * 查询用户通过系统邮件
     *
     * @param sysemail    sysemail
     * @param syspassword syspassword
     * @return {@link List}<{@link SysUser}>
     */
    List<SysUser> queryUserBySysEmail(String sysemail,String syspassword);

}
