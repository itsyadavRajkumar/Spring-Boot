package com.token.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.token.entity.User;
import com.token.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final Map<Long, User> users = new ConcurrentHashMap<>();
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(ObjectMapper objectMapper, PasswordEncoder passwordEncoder) {
        this.objectMapper = objectMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String createUser(User user) {
        if (user == null || user.getId() == null) {
            log.error("User having null value");
            return "Invalid User!!";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("User password encode successfully with id: {} and encoded password {}", user.getId(), user.getPassword());
        users.put(user.getId(), user);
        log.info("Successfully created user id: {}", user.getId());
        return "Successfully create User!!";
    }

    @Override
    public String getUsersDetails(Long id) {
        User user = users.get(id);
        if (user == null) {
            log.warn("User not found on given id: {}", id);
            return "Invalid User Id!!";
        }
        try {
            log.info("Successfully fetched user data with id: {}", id);
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            log.error("Getting JsonProcessingException while serializing user with id: {}", id, e);
            return "Not Found User!!";
        }
    }
}
