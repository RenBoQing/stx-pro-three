package com.stx.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stx.pro.mapper.SysUserMapper;
import com.stx.pro.pojo.SysUser;
import com.stx.pro.service.SysUserService;
import com.stx.pro.vos.SysUserDeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServicelmpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper SysuserMapper;

    /*
     *通过邮箱登录
     * @author RenBoQing
     * @date 2022/6/16 0016 21:32
     * @param sysemail
     * @param syspassword
     * @return java.util.List<com.stx.pro.pojo.SysUser>
     */
    @Override
    public List<SysUser> querySysUserBysysemail(String sysemail, String syspassword) {
        return SysuserMapper.queryUserBySysEmail(sysemail, syspassword);
    }
     /*
      *查询管理员用户的所属部门
      * @author RenBoQing
      * @date 2022/11/15 0015 22:38
      * @return java.util.List<com.stx.pro.vos.SysUserDeptVo>
      */
    @Override
    public List<SysUserDeptVo> querySysDeptVo() {
        return SysuserMapper.querySysDeptVo();
    }

}



