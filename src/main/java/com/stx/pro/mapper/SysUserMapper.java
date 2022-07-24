package com.stx.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stx.pro.pojo.SysUser;
import com.stx.pro.vos.SysUserDeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    /*
     *邮箱登录
     * @author TanShen
     * @date 2022/6/17 0017 9:10
     * @param sysemail
     * @param syspassword
     * @return java.util.List<com.stx.pro.pojo.SysUser>
     */
    List<SysUser> queryUserBySysEmail(String sysemail, String syspassword);

    /*
     *
     * @author RenBoQing
     * @date 2022/7/9 0009 19:50
     * @return java.util.List<com.stx.pro.vos.SysUserDeptVo>
     */
    List<SysUserDeptVo> querySysDeptVo();
}
