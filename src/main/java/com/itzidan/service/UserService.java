package com.itzidan.service;

import com.itzidan.domain.User;

public interface UserService {
    public boolean addUser(User user);
    public boolean activateUser(String uuid);
}
