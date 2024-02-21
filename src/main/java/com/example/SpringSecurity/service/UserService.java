package com.example.SpringSecurity.service;

import com.example.SpringSecurity.model.User;

public interface UserService
{
    public User createUser(User user);
    public boolean checkEmail(String email);
}
