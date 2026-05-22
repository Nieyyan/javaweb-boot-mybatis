package com.woxueit.boot.service;

import com.woxueit.boot.mapper.UserMapper;
import com.woxueit.boot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int modifyUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int removeUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public User findUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> findUsers() {
        return userMapper.getUsers();
    }
}
