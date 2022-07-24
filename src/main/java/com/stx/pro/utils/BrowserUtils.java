package com.stx.pro.utils;

import com.stx.pro.pojo.SysUserLog;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @author RenBoQing
 * @date 2022年06月18日 15:33
 * @Description
 */
@Slf4j
public class BrowserUtils {
    public static SysUserLog getBrowser(HttpServletRequest request) {
        SysUserLog sysUserLog = new SysUserLog();
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-agent"));
        String clientType = userAgent.getOperatingSystem().getDeviceType().toString();
        sysUserLog.setClienttype(clientType);
        log.info("clientType = " + clientType);   //客户端类型  手机、电脑、平板
        String os = userAgent.getOperatingSystem().getName();
        sysUserLog.setSystemos(os);
        log.info("os = " + os);    //操作系统类型
        String ip = ClientIpUtils.getIpAddr(request);
        log.info("ip = " + ip);    //请求ip
        sysUserLog.setOperateaddress(ip);
        String browser = userAgent.getBrowser().toString();
        log.info("browser = " + browser);   // 浏览器类型
        sysUserLog.setBrowser(browser);
        return sysUserLog;
    }
}
