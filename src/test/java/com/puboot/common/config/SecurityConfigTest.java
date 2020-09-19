package com.puboot.common.config;

import com.puboot.BaseTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Nobita
 * @date 2020/9/17 5:14 下午
 */
@Slf4j
class SecurityConfigTest extends BaseTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void passwordEncoder() {
        String password = "123456";
        String encodedPwd = passwordEncoder.encode(password);
        log.info("password: {}, encodedPwd: {}", password, encodedPwd);
        assertTrue(passwordEncoder.matches(password, encodedPwd));
    }
}