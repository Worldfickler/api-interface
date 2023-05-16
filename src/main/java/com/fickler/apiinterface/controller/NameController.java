package com.fickler.apiinterface.controller;

import com.fickler.apiinterface.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * 名称 API
 * @author dell
 * @date 2023/5/16 10:41
 */

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name) {
        return "GET 你的名字是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user) {
        return "POST 用户名字是" + user.getUsername();
    }

}
