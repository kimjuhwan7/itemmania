package com.itemmania.service.userService;

import com.itemmania.entity.UserEntity;
import com.itemmania.mapper.UserMapper;
import com.itemmania.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired(required = false)
    private UserRepository userRepository;

    @Autowired(required = false)
    private UserMapper userMapper;

    public UserEntity getUser(String userName, String userPassword)
    {
        return userRepository.findByUserNameAndUserPassword(userName, userPassword);
    }
    public boolean isExistUser(String userName, String userPassword)
    {
        return userRepository.existsByUserNameAndUserPassword(userName, userPassword);
    }
}
