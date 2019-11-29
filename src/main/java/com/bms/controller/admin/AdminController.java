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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private HttpServletRequest request;
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

    @GetMapping("/profile")
    public String profile() {
        Long id = (long) session.getAttribute("loginUserId");
        User user = iUserService.getById(id);
        if (user == null) {
            return "admin/login";
        }
        request.setAttribute("path", "profile");
        request.setAttribute("loginUserName", user.getUserName());
        request.setAttribute("nickName", user.getNickName());
        return "admin/profile";
    }

    @PostMapping("/profile/password")
    @ResponseBody
    public String passwordUpdate(String originalPassword, String newPassword) {
        if (StringUtils.isEmpty(originalPassword) || StringUtils.isEmpty(newPassword)) {
            return "参数不能为空";
        }
        Long id = (long) session.getAttribute("loginUserId");

        User user = User.builder()
                .password(MD5Util.MD5Encode(newPassword, "UTF-8"))
                .build();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getId, id);
        queryWrapper.lambda().eq(User::getPassword, MD5Util.MD5Encode(originalPassword, "UTF-8"));
        boolean updateFlag = iUserService.update(user, queryWrapper);
        if (updateFlag) {
            //修改成功后清空session中的数据，前端控制跳转至登录页
            session.removeAttribute("loginUserId");
            session.removeAttribute("loginUser");
            session.removeAttribute("errorMsg");
            return "success";
        } else {
            return "修改失败";
        }
    }

    @PostMapping("/profile/name")
    @ResponseBody
    public String nameUpdate(String loginUserName, String nickName) {
        if (StringUtils.isEmpty(loginUserName) || StringUtils.isEmpty(nickName)) {
            return "参数不能为空";
        }
        Long id = (long) session.getAttribute("loginUserId");

        User admin = User.builder()
                .id(id)
                .userName(loginUserName)
                .nickName(nickName)
                .build();

        boolean updateFlag = iUserService.updateById(admin);
        if (updateFlag) {
            return "success";
        } else {
            return "修改失败";
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
