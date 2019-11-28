package com.bms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Long adminId;

    private String loginName;

    private String loginPassword;

    private String adminNickName;

    private Byte locked;
}