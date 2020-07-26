package com.springcloud.server;

import com.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springcloud.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User findById(int id){
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("用户不存在"));
    }
}
