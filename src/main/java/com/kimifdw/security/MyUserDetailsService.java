package com.kimifdw.security;

import com.google.common.collect.Lists;
import com.kimifdw.model.User;
import com.kimifdw.resposities.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * spring security 认证管理服务类
 * Created by kimiyu on 15/7/12.
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        logger.info("start login...");
        AuthUserDetails authUserDetails = null;
        try {
            User user = userRepository.findByLoginName(loginName);
            if (user == null || user.getId() == null) {
                throw new UsernameNotFoundException("user 【" + loginName + "】 not fund！");
            }
            //用户权限
            List<GrantedAuthority> authorities = Lists.newArrayList();
            //TODO 查询用户权限,设置权限到spring-security
            //for test
            if (user.getRoles() == null || user.getRoles().size() == 0) {
                List<String> roles = Lists.newArrayList("ROLE_USER");
                user.setRoles(roles);
            }
            for (String role : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
            authUserDetails = new AuthUserDetails(loginName, user.getPassword(), true, true, true
                    , !(user.getIsLocked() == 1), authorities);
            authUserDetails.setUserId(user.getId());
            authUserDetails.setName(user.getUserName());
            //更新用户
            user.setLastLoginTime(new Date());
            userRepository.save(user);
        } catch (Exception e) {
            logger.error("MyUserDetailsService.loadUserByUsername fail", e);
            if (e instanceof UsernameNotFoundException) {
                throw new UsernameNotFoundException("user 【" + loginName + "】 not found！");
            }
        }
        return authUserDetails;
    }
}
