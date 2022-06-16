package com.stx.pro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stx.pro.pojo.SysUser;

import java.util.List;

public interface SysUserService extends IService<SysUser> {


    List<SysUser> querySysUserBysysemail(String sysemail, String syspassword);

}