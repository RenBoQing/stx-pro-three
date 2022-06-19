package com.stx.pro.controller;

import com.stx.pro.pojo.SysUser;
import com.stx.pro.pojo.SysUserLog;
import com.stx.pro.service.SysUserLogService;
import com.stx.pro.service.SysUserService;
import com.stx.pro.utils.BrowserUtils;
import com.stx.pro.utils.CommonResult;
import com.stx.pro.utils.JsonObject;
import com.stx.pro.vos.SysUserDeptVo;
import com.wf.captcha.utils.CaptchaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sysUsers")
@Slf4j
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserLogService sysUserLogService;

    /**
     * 查询所有系统用户
     *
     * @return {@link CommonResult}
     */
    @RequestMapping("/sysUserList")
    @ResponseBody
    public JsonObject queryAllSysUser(HttpSession session, HttpServletRequest request) {
        List<SysUser> userInfo = (List<SysUser>) session.getAttribute("userInfo");
        List<SysUserDeptVo> sysUserDeptVos = sysUserService.querySysDeptVo();
        SysUserLog browser = BrowserUtils.getBrowser(request);
        browser.setTitle("查询所有管理员");
        browser.setDescription("请求成功");
        browser.setOperateurl(request.getRequestURI());
        browser.setSuccess(1);
        browser.setCreatetime(new Date());

        //browser.setSuid(userInfo.get(1).getSuid());
        //browser.setSysnickname(userInfo.get(1).getSysnickname());
        sysUserLogService.save(browser);
        session.setAttribute("userInfo", sysUserDeptVos);
        if (sysUserDeptVos.size() > 0) {
            return JsonObject.success(0, sysUserDeptVos, "查询成功", (long) sysUserDeptVos.size());
        } else {
            return JsonObject.fail(0, "暂时没有数据");
        }
    }

    /**
     * 根据sysemail登录
     *
     * @param sysemail    sysemail
     * @param syspassword syspassword
     * @return {@link JsonObject}
     */
    @RequestMapping(value = "/loginBySyseamil")
    @ResponseBody
    public JsonObject queryUserBySysEmail(String sysemail, String syspassword, HttpSession session, HttpServletRequest request, String captcha) {
        // 获取session中的验证码
        String sessionCode = (String) request.getSession().getAttribute("captcha");
        // 判断验证码
        log.warn(sessionCode);
        if (!CaptchaUtil.ver(captcha, request)) {
            CaptchaUtil.clear(request);
            return JsonObject.fail(1, "验证码不正确");
            //先进行验证码的验证
        } else {
            List<SysUser> sysUserList = sysUserService.querySysUserBysysemail(sysemail, syspassword);
            session.setAttribute("userInfo", sysUserList);
            if (sysUserList.size() > 0) {
                log.warn(sysUserList.toString());
                return JsonObject.success(0, "登录成功");
            } else {
                return JsonObject.fail(1, "用户名或密码错误");
            }

        }
    }
    /**
     * 根据suid删除系统用户
     * @param suid suid
     * @return {@link JsonObject}
     */
    @RequestMapping(value = "/del/{suid}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonObject deleteSysUserBySuid(@PathVariable("suid") Long suid,HttpServletRequest request,HttpSession session) {
        SysUserLog browser = BrowserUtils.getBrowser(request);
        browser.setTitle("删除用户");
        browser.setDescription("请求成功");
        browser.setOperateurl(request.getRequestURI());
        browser.setSuccess(1);
        browser.setCreatetime(new Date());
        //List<SysUser> userInfo = (List<SysUser>) session.getAttribute("userInfo");
        //browser.setSuid(userInfo.get(1).getSuid());
        //browser.setSysnickname(userInfo.get(1).getSysnickname());
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
     * @param ids ids
     * @return {@link CommonResult}
     */
    @RequestMapping(value = "/delSysUserDeptid", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult delSysUserByDeptid(String ids,HttpSession session, HttpServletRequest request) {
        SysUserLog browser = BrowserUtils.getBrowser(request);
        browser.setTitle("批量删除");
        browser.setDescription("请求成功");
        browser.setOperateurl(request.getRequestURI());
        browser.setSuccess(1);
        browser.setCreatetime(new Date());
        //List<SysUser> userInfo = (List<SysUser>) session.getAttribute("userInfo");
        //browser.setSuid(userInfo.get(1).getSuid());
        //browser.setSysnickname(userInfo.get(1).getSysnickname());

        //将获取到的ids的数组进行分割
        String[] strs = ids.split(",");
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

    /*
     *修改管理员信息
     * @author RenBoQing
     * @date 2022/6/18 0018 13:55
     * @param sysUser
     * @return com.stx.pro.utils.CommonResult
     */
    @RequestMapping(value = "/updateBySuid", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateBySuid(SysUser sysUser,HttpSession session, HttpServletRequest request) {
        SysUserLog browser = BrowserUtils.getBrowser(request);
        browser.setTitle("批量删除");
        browser.setDescription("请求成功");
        browser.setOperateurl(request.getRequestURI());
        browser.setSuccess(1);
        browser.setCreatetime(new Date());
        //List<SysUser> userInfo = (List<SysUser>) session.getAttribute("userInfo");
        //browser.setSuid(userInfo.get(1).getSuid());
        //browser.setSysnickname(userInfo.get(1).getSysnickname());
        boolean updateById = sysUserService.updateById(sysUser);
        if (updateById) {
            return CommonResult.success("修改成功");
        } else {
            return CommonResult.failed("修改失败");
        }
    }


    /*
     *添加管理员
     * @author RenBoQing
     * @date 2022/6/18 0018 13:55
     * @param sysUser
     * @return com.stx.pro.utils.JsonObject
     */
    @RequestMapping(value = "/sysUserJoin", method = RequestMethod.GET)
    @ResponseBody
    public JsonObject join(SysUser sysUser,HttpSession session, HttpServletRequest request) {
        SysUserLog browser = BrowserUtils.getBrowser(request);
        browser.setTitle("批量删除");
        browser.setDescription("请求成功");
        browser.setOperateurl(request.getRequestURI());
        browser.setSuccess(1);
        browser.setCreatetime(new Date());
        List<SysUser> userInfo = (List<SysUser>) session.getAttribute("userInfo");
        //browser.setSuid(userInfo.get(1).getSuid());
        //browser.setSysnickname(userInfo.get(1).getSysnickname());
        sysUser.setSystatus(1);
        sysUser.setCreatetime(new Date());
        sysUser.setUpdatetime(new Date());
        boolean insert = sysUserService.save(sysUser);
        if (insert) {
            return JsonObject.success(0, "添加成功");
        } else {
            return JsonObject.fail(1, "添加失败");
        }
    }
}

