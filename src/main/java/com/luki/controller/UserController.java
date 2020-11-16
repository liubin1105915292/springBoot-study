package com.luki.controller;

import com.luki.exception.ParamsException;
import com.luki.pojo.User;
import com.luki.pojo.vo.ResultInfo;
import com.luki.server.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    //日志
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping("index")
    @ResponseBody
    public String index() {
        return "好好学习,天天向上!";
    }

    @ResponseBody
    @GetMapping("qury/{userName}")
    public User quryUserByName(@PathVariable String userName) {
        User user = this.userService.quryUserByName(userName);
        return user;
    }

    @PostMapping("addUser")
    @ResponseBody
    public ResultInfo addUser(@RequestBody User user) {
        log.info("新增用户,user(" + user + ")");
        ResultInfo result = new ResultInfo();
        try {
            userService.addUser(user);
        } catch (ParamsException e) {
            log.error("发生异常: ", e);
            e.printStackTrace();
            result.setCode(e.getCode());
            result.setMsg(e.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("程序异常!");
        }
        return result;
    }

    @ResponseBody
    @GetMapping("qury")
    public ResultInfo quryUser(@RequestBody User user) {
        ResultInfo result = new ResultInfo();
        try {
            User _user = userService.quryUser(user);
            result.setResult(_user);
        } catch (ParamsException e) {
            result.setCode(e.getCode());
            result.setMsg(e.getMsg());
        } catch (Exception e) {
            result.setCode(500);
            result.setMsg("服务器异常!");
        }
        return result;
    }
}
