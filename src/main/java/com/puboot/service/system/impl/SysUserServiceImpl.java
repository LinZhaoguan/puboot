package com.puboot.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.puboot.entity.system.SysUser;
import com.puboot.mapper.system.SysUserMapper;
import com.puboot.service.system.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Nobita
 * @date 2020/9/17 3:13 下午
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
