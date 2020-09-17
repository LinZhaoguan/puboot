package com.puboot.common.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Nobita
 * @date 2020/9/17 5:14 下午
 */
@SpringBootTest
class SpringSecurityConfigTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void passwordEncoder() {
        String password = "puboot.com";
        String encodedPwd = passwordEncoder.encode(password);
        assertTrue(passwordEncoder.matches(password, encodedPwd));
    }
}