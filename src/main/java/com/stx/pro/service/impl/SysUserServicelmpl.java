package com.stx.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stx.pro.mapper.SysUserMapper;
import com.stx.pro.mapper.UserMapper;
import com.stx.pro.pojo.SysUser;
import com.stx.pro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServicelmpl  extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper SysuserMapper;

    @Override
    public SysUser selectUserBySysemail(String sysemail) {
        return selectUserBySysemail(sysemail);
    }

    @Override
    public int insert(SysUser sysUser) {
        return 0;
    }

    @Override
    public List<SysUser> querySysUserBysysemail(String sysemail, String syspassword) {
        return SysuserMapper.queryUserBySysEmail(sysemail, syspassword);
    }
    @Override
    public List<SysUser> queryAllSysUser(String sysemail) {
        return SysuserMapper.queryAllSysUser(sysemail);
    }
}



