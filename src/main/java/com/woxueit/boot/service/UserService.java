package com.woxueit.boot.service;

import com.woxueit.boot.pojo.User;

import java.util.List;

public interface UserService {

    public int saveUser(User user);

    public int modifyUser(User user);

    public int removeUserById(int id);

    public User findUserById(int id);

    public List<User> findUsers();

}
