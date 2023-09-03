package com.fickler.apiinterface.controller;

import com.fickler.apiclientsdk.model.User;
import com.fickler.apiclientsdk.utils.SingUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        // todo 实际去数据库查看是否一分配给用户
        if (!accessKey.equals("test")) {
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }
        String serverSign = SingUtils.getSign(body, "abcdefg");
        if (!sign.equals(serverSign)) {
            throw new RuntimeException("无权限");
        }
        String result = "POST 用户名字是" + user.getUsername();
        return result;
    }

}
