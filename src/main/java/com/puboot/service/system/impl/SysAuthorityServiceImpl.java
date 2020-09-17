package com.puboot.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.puboot.entity.system.SysAuthority;
import com.puboot.mapper.system.SysAuthorityMapper;
import com.puboot.service.system.SysAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Nobita
 * @date 2020/9/17 3:13 下午
 */
@Slf4j
@Service
public class SysAuthorityServiceImpl extends ServiceImpl<SysAuthorityMapper, SysAuthority> implements SysAuthorityService {
    @Override
    public Set<SysAuthority> loadUserAuthorities(String username) {
        return baseMapper.loadUserAuthorities(username);
    }
}
