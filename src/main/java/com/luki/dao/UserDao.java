package com.luki.dao;

import com.luki.pojo.User;

public interface UserDao {
    //根据用户名查询用户
    public User quryUserByName(String name);

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user);
}
