package com.woxueit.boot.mapper;

import com.woxueit.boot.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUserById(@Param("id") int id);

    public User getUserById(@Param("id") int id);

    public List<User> getUsers();
}
