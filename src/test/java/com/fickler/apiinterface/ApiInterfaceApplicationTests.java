package com.fickler.apiinterface;

import com.fickler.apiclientsdk.client.ApiClient;
import com.fickler.apiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {

	@Resource
	private ApiClient apiClient;

	@Test
	void contextLoads() {
		String result1 = apiClient.getNameByGet("test");
		String result2 = apiClient.getNameByPost("test");
		User user = new User();
		user.setUsername("test");
		String result3 = apiClient.getUsernameByPost(user);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}

}
