package com.stx.pro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stx.pro.pojo.SysUser;

import java.util.List;

public interface SysUserService extends IService<SysUser> {

    /**
     * 查询系统用户bysysemail
     * @param sysemail    sysemail
     * @param syspassword syspassword
     * @return {@link List}<{@link SysUser}>
     */
    List<SysUser> querySysUserBysysemail(String sysemail, String syspassword);

}
