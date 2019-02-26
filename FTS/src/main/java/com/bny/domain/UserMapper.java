package com.bny.domain;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface UserMapper
{
    void insertUser(User user);
    User findUserById(Integer id);
    List<User> findAllUsers();
}