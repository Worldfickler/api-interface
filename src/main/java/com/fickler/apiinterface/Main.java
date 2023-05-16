package com.fickler.apiinterface;

import com.fickler.apiinterface.clint.ApiClient;
import com.fickler.apiinterface.model.User;

/**
 * @author dell
 * @date 2023/5/16 11:10
 */
public class Main {

    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        String result1 = apiClient.getNameByGet("test get");
        String result2 = apiClient.getNameByPost("test post");
        User user = new User();
        user.setUsername("test restful");
        String result3 = apiClient.getUsernameByPost(user);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

}
