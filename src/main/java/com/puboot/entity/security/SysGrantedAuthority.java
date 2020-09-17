package com.puboot.entity.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Nobita
 * @date 2020/9/17 4:33 下午
 */
@Data
@AllArgsConstructor
public class SysGrantedAuthority implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private final String principal;
    private final String authName;
    private final String authCode;
    private final String authUrl;
    private final Integer authType;
    private final String authIcon;
    private final Integer authOrder;
    private final String authDescription;

    @Override
    public String getAuthority() {
        return authCode;
    }
}
