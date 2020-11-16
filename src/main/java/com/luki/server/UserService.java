package com.luki.server;

import com.luki.dao.UserDao;
import com.luki.pojo.User;
import com.luki.util.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User quryUserByName(String userName) {
        return userDao.quryUserByName(userName);
    }

    /**
     * 添加用户
     * 1.非空检验
     * 2.验证用户名的唯一性
     * 3.添加用户记录,判断受影响的行数
     *
     * @param user
     */
    public void addUser(User user) {
        //非空校验
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()), "用户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(user.getPassword()), "密码不能为空");

        User temp = userDao.quryUserByName(user.getUserName());

        AssertUtil.isTrue(temp != null, "用户名已存在,请重试!");

        AssertUtil.isTrue(userDao.addUser(user) != 1, "用户添加失败!");
    }

    /**
     * 根据多种条件查询用户
     *
     * @param user
     * @return
     */
    public User quryUser(User user) {
        //非空校验
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()) && user.getUserId() == null,
                "查询条件不能为空");
        return userDao.quryUser(user);
    }
}
