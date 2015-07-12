package com.kimifdw.service;

import com.kimifdw.model.User;
import com.kimifdw.resposities.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kimiyu on 15/7/12.
 */
@Service
@Transactional
public class UserService extends BaseService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getUserByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
