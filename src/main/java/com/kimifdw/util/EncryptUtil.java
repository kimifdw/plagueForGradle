package com.kimifdw.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Security加密工具类
 * Created by kimiyu on 15/7/11.
 */
@Component
public class EncryptUtil {

    private final static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    //spring-security的加密方法
    public static String SpringSecurityEncode(String password) {
        return ENCODER.encode(password);
    }
}
