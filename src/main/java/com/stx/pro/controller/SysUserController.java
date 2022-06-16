package com.stx.pro.controller;

import com.stx.pro.pojo.SysUser;
import com.stx.pro.service.SysUserService;
import com.stx.pro.utils.CommonResult;
import com.stx.pro.utils.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sysUsers")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询所有系统用户
     *
     * @return {@link CommonResult}
     */
    @RequestMapping("/sysUserList")
    @ResponseBody
    public CommonResult queryAllSysUser() {
        List<SysUser> list = sysUserService.list();
        if (list.size() > 0) {
            return CommonResult.success("查询成功");
        } else {
            return CommonResult.failed("暂时没有数据");
        }
    }

    /**
     * 根据sysemail登录
     *
     * @param sysemail    sysemail
     * @param syspassword syspassword
     * @return {@link JsonObject}
     */
    @RequestMapping(value = "/loginBySyseamil/{sysemail}/{syspassword}", method = RequestMethod.POST)
    @ResponseBody
    public JsonObject queryUserBySysEmail(@PathVariable("sysemail") String sysemail, @PathVariable("syspassword") String syspassword) {
        List<SysUser> sysUserList = sysUserService.querySysUserBysysemail(sysemail, syspassword);
        if (sysUserList.size() > 0) {
            return JsonObject.success(0, sysUserList, "查询成功", (long) sysUserList.size());
        } else {
            return JsonObject.fail(1, "用户或密码错误");
        }
    }

    /**
     * 根据suid删除系统用户
     *
     * @param suid suid
     * @return {@link JsonObject}
     */
    @RequestMapping(value = "/del/{suid}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonObject deleteSysUserBySuid(@PathVariable("suid") Long suid) {
        boolean b = sysUserService.removeById(suid);
        if (b) {
            return JsonObject.success(0, "删除成功");
        } else {
            return JsonObject.fail(1, "删除失败");
        }
    }

    /**
     * 通过deptid批量删除系统用户
     *
     * @param deptid deptid
     * @return {@link CommonResult}
     */
    @RequestMapping(value = "/delSysUserDeptid", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult delSysUserByDeptid(String deptid) {
        //将获取到的ids的数组进行分割
        String[] strs = deptid.split(",");
        List<Long> delList = new ArrayList<>();
        //遍历这些ids 并将其添加到List集合中
        for (String str : strs) {
            delList.add(Long.parseLong(str));
        }
        //是否删除成功
        boolean b = sysUserService.removeByIds(delList);
        ;
        if (b) {
            return CommonResult.success("删除成功");
        } else {
            return CommonResult.failed("删除失败");
        }
    }

    /**
     * 修改用户信息
     *
     * @param sysUser 系统用户
     * @return {@link CommonResult}
     */
    @RequestMapping(value = "/updateBySuid", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateBySuid(SysUser sysUser) {
        boolean updateById = sysUserService.updateById(sysUser);
        if (updateById) {
            return CommonResult.success("修改成功");
        } else {
            return CommonResult.failed("修改失败");
        }
    }


    /**
     * 添加用户
     * @param sysUser 系统用户
     * @return {@link JsonObject}
     */
    @RequestMapping(value = "/sysUserJoin", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject join(SysUser sysUser) {
        boolean insert = sysUserService.save(sysUser);
        if (insert) {
            return JsonObject.success(0, "添加成功");
        } else {
            return JsonObject.fail(1, "添加失败");
        }
    }
}

