package com.stx.pro.intercreptor;

import com.stx.pro.pojo.SysUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author RenBoQing
 * @date 2022年03月24日 19:31
 * @Description 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session中的user
        List<SysUser> userInfo = (List<SysUser>)  request.getSession().getAttribute("userInfo");
        if (userInfo == null) {
            response.sendRedirect(request.getContextPath() + "/adminLogin");
            return false;
        }
        return true;
    }
}
