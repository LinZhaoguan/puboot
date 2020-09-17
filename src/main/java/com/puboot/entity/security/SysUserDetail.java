package com.puboot.entity.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Nobita
 * @date 2020/9/17 4:13 下午
 */
@Data
@AllArgsConstructor
public class SysUserDetail implements UserDetails {

    private static final long serialVersionUID = 1L;

    private final String username;
    private final String password;
    private final Set<SysGrantedAuthority> authorities;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;

}
