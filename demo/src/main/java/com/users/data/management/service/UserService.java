package com.test.service;

import com.test.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserData(Long id);
    UserDto updateUserData(UserDto userDto);
}
