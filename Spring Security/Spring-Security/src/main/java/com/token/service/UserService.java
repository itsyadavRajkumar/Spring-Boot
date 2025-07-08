package com.token.service;

import com.token.entity.User;

public interface UserService {
    String createUser(User user);
    String getUsersDetails(Long id);
}
