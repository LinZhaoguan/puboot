package com.puboot.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.puboot.entity.system.SysAuthority;

import java.util.Set;

public interface SysAuthorityMapper extends BaseMapper<SysAuthority> {

    /**
     * 根据用户账号获取对应的权限集合
     *
     * @param username
     * @return
     */
    Set<SysAuthority> loadUserAuthorities(String username);
}