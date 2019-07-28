package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.until.LogUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("test")
    public List<User> user() {
        return userService.getlist();
    }
    @GetMapping("/helloworld")
    public String helloworld() throws Exception{
        Logger log = LogUtils.getExceptionLogger();
        Logger log1 = LogUtils.getBussinessLogger();
        Logger log2 = LogUtils.getDBLogger();
        userService.getlist();
        log.error("getExceptionLogger===日志测试");
        log1.info("getBussinessLogger===日志测试");
        log2.debug("getDBLogger===日志测试");
        return "helloworld";
    }
}
