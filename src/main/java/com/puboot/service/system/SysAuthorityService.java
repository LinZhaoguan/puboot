package com.puboot.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.puboot.entity.system.SysAuthority;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Nobita
 * @date 2020/9/17 3:12 下午
 */
public interface SysAuthorityService extends IService<SysAuthority> {

    /**
     * 根据用户账号获取对应的权限集合
     *
     * @param username
     * @return
     */
    Set<SysAuthority> loadUserAuthorities(String username);
}
