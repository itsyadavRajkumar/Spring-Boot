package com.users.data.management.service;

import com.users.data.management.payload.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserData(Long id);
    UserDto updateUserData(UserDto userDto);
}
