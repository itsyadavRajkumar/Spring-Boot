package com.test.service.impl;

import com.test.dto.UserDto;
import com.test.entity.User;
import com.test.repository.UserRepo;
import com.test.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setMobile(userDto.getMobile());
        User savedUser = userRepo.save(user);
//        userDto.setId(savedUser.getId());
        return userDto;
    }

    @Override
    public UserDto getUserData(Long id) {
        UserDto userDto = new UserDto();
        User user = userRepo.getById(id);
        userDto.setId(user.getId());
        userDto.setMobile(user.getMobile());
        userDto.setName(user.getName());
        return userDto;
    }

    @Override
    public UserDto updateUserData(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setMobile(userDto.getMobile());
        User savedUser = userRepo.save(user);
        return userDto;
    }
}
