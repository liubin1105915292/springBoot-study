package com.luki.dao;

import com.luki.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    //根据用户名查询用户
    public User quryUserByName(String name);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int addUser(User user);

    @Select("SELECT * FROM luki_user WHERE USER_ID=#{userId}")
    public User quryUser(User user);
}
