package com.notepad.controller;

import com.notepad.cache.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: user service
 * date: 2022/7/23
 *
 * @author Marvin Yang
 */
@Api(tags = "user")
@RequestMapping("/user/")
@RestController
public class UserApi {
    @Autowired
    private UserService userService;

    @ApiOperation("save")
    @GetMapping("/save/")
    public boolean save(String userId) {
        userService.save(userId);
        return true;
    }

    @ApiOperation("find")
    @GetMapping("/find/")
    public String find(String userId) {
        return userService.find(userId);
    }
}
