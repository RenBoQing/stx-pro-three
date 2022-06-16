package com.stx.pro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stx.pro.pojo.SysUser;

import java.util.List;

public interface SysUserService extends IService<SysUser> {

    /*
     *通过邮箱登录
     * @author RenBoQing
     * @date 2022/6/16 0016 21:31
     * @param sysemail
     * @param syspassword
     * @return java.util.List<com.stx.pro.pojo.SysUser>
     */
    List<SysUser> querySysUserBysysemail(String sysemail, String syspassword);

}
