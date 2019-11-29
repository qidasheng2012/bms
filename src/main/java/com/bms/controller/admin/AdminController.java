package com.bms.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bms.entity.User;
import com.bms.service.IUserService;
import com.bms.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private HttpSession session;


    @GetMapping({"/login"})
    public String login() {
        return "admin/login";
    }

    @GetMapping({"", "/", "/index", "/index.html"})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "index");
        return "admin/index";
    }

    @PostMapping(value = "/login")
    public String login(String userName, String password, String verifyCode) {
        if (StringUtils.isEmpty(verifyCode)) {
            session.setAttribute("errorMsg", "验证码不能为空");
            return "admin/login";
        }
        if (StringUtils.isEmpty(userName)) {
            session.setAttribute("errorMsg", "用户名不能为空");
            return "admin/login";
        }
        if (StringUtils.isEmpty(password)) {
            session.setAttribute("errorMsg", "密码不能为空");
            return "admin/login";
        }

        String kaptchaCode = String.valueOf(session.getAttribute("verifyCode"));
        if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
            session.setAttribute("errorMsg", "验证码错误");
            return "admin/login";
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserName, userName);
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        queryWrapper.lambda().eq(User::getPassword, passwordMd5);
        User user = iUserService.getOne(queryWrapper);
        if (user != null) {
            session.setAttribute("loginUser", user.getNickName());
            session.setAttribute("loginUserId", user.getId());
            //session过期时间设置为7200秒 即两小时
            //session.setMaxInactiveInterval(60 * 60 * 2);
            return "redirect:/admin/index";
        } else {
            session.setAttribute("errorMsg", "登陆失败");
            return "admin/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("loginUserId");
        session.removeAttribute("loginUser");
        session.removeAttribute("errorMsg");
        return "admin/login";
    }
}
