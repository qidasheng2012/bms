package com.bms.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bms.entity.User;
import com.bms.service.IUserService;
import com.bms.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;

    @GetMapping
    public String profile() {
        Long id = (long) session.getAttribute("loginUserId");
        User user = iUserService.getById(id);
        if (user == null) {
            return "admin/login";
        }
        request.setAttribute("path", "profile");
        request.setAttribute("userName", user.getUserName());
        request.setAttribute("nickName", user.getNickName());
        return "admin/profile";
    }

    @PutMapping("/updatePassword")
    @ResponseBody
    public String updatePassword(String originalPassword, String newPassword) {
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

    @PutMapping("/updateName")
    @ResponseBody
    public String updateName(String userName, String nickName) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(nickName)) {
            return "参数不能为空";
        }
        Long id = (long) session.getAttribute("loginUserId");

        User admin = User.builder()
                .id(id)
                .userName(userName)
                .nickName(nickName)
                .build();

        boolean updateFlag = iUserService.updateById(admin);
        if (updateFlag) {
            return "success";
        } else {
            return "修改失败";
        }
    }
}
