package com.zhuandian.apptest;

import com.zhuandian.apptest.pojo.UserEntity;
import com.zhuandian.apptest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import utils.Response;

@SpringBootTest
class ApptestApplicationTests {

@Autowired
UserService userService;
//	@Test
	void contextLoads() {
		Response login = userService.login("o0I-z0_", "zph199838");
		System.out.println(login);
	}

}
