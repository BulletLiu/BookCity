package com.itzidan.mapper;

import com.itzidan.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public void insertUser(User user);
    public String selectUserByUUID(String uuid);
    public void updateStatusByUUID(String uuid);
}
