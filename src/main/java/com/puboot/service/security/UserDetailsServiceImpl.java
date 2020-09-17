package com.puboot.service.security;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.puboot.entity.security.SysGrantedAuthority;
import com.puboot.entity.security.SysUserDetail;
import com.puboot.entity.system.SysAuthority;
import com.puboot.entity.system.SysUser;
import com.puboot.service.system.SysAuthorityService;
import com.puboot.service.system.SysUserService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Nobita
 * @date 2020/9/17 4:04 下午
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SysUserService sysUserService;
    private final SysAuthorityService sysAuthorityService;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {

        // 查询用户信息
        SysUser user = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
        if (user == null) {
            log.error("Query returned no results for user '{}'", username);
            throw new UsernameNotFoundException("Username: " + username + " not found");
        }

        // 查询用户权限集合
        Set<SysAuthority> dbAuthsSet = sysAuthorityService.loadUserAuthorities(username);
        if (CollectionUtils.isEmpty(dbAuthsSet)) {
            log.error("User '{}' has no authorities and will be treated as 'not found'", username);
            throw new UsernameNotFoundException("User: " + username + " has no GrantedAuthority");
        }
        Set<SysGrantedAuthority> grantedAuthoritySet = dbAuthsSet.stream().map(auth -> {
            return new SysGrantedAuthority(user.getUsername(), auth.getAuthName(), auth.getAuthCode(),
                    auth.getAuthUrl(), auth.getAuthType(), auth.getAuthIcon(), auth.getAuthOrder(), auth.getAuthDescription());
        }).collect(Collectors.toSet());

        // 创建 Spring Security 所需要的用户信息
        return new SysUserDetail(user.getUsername(), user.getPassword(), grantedAuthoritySet, true,
                Boolean.FALSE.equals(user.getLocked()), true, Boolean.TRUE.equals(user.getEnabled()));
    }
}
