package com.bms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bms.dao.AdminMapper;
import com.bms.entity.Admin;
import com.bms.service.IAdminService;
import com.bms.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        return adminMapper.login(userName, passwordMd5);
    }

    @Override
    public Admin getUserDetailById(Long loginUserId) {
        return adminMapper.selectByPrimaryKey(loginUserId);
    }

    @Override
    public Boolean updatePassword(Long loginUserId, String originalPassword, String newPassword) {
        Admin adminUser = adminMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            String originalPasswordMd5 = MD5Util.MD5Encode(originalPassword, "UTF-8");
            String newPasswordMd5 = MD5Util.MD5Encode(newPassword, "UTF-8");
            //比较原密码是否正确
            if (originalPasswordMd5.equals(adminUser.getLoginPassword())) {
                //设置新密码并修改
                adminUser.setLoginPassword(newPasswordMd5);
                if (adminMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                    //修改成功则返回true
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean updateName(Long loginUserId, String loginUserName, String nickName) {
        Admin adminUser = adminMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            //设置新密码并修改
            adminUser.setLoginName(loginUserName);
            adminUser.setAdminNickName(nickName);
            if (adminMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                //修改成功则返回true
                return true;
            }
        }
        return false;
    }
}
