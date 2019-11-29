package com.bms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_admin_user")
public class Admin {
    @TableId(type = IdType.AUTO)
    private Long adminId;

    private String loginName;

    private String loginPassword;

    private String adminNickName;

    private Byte locked;
}