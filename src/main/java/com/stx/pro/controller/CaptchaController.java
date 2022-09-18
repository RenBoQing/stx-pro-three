package com.stx.pro.controller;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author RenBoQing
 * @date 2022年05月30日 19:32
 * @Description 验证码接口
 */
@Controller
public class CaptchaController {
    /*
     *图形验证码
     * @author RenBoQing
     * @date 2022/5/30 0030 19:34
     * @param request
     * @param response
     */
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //设置验证码类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        SpecCaptcha specCaptcha = new SpecCaptcha();
        request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());
        specCaptcha.out(response.getOutputStream());
    }
}
