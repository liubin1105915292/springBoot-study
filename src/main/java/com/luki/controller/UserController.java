package com.luki.controller;

import com.luki.exception.ParamsException;
import com.luki.pojo.User;
import com.luki.pojo.vo.ResultInfo;
import com.luki.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {


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
        ResultInfo result = new ResultInfo();
        try {
            userService.addUser(user);
        } catch (ParamsException e) {
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

}
