package com.example.board;

import com.example.board.jasypt.JasyptTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class NoticeboardApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private JasyptTest jasyptTest;

	@Test
	void jasypt_test(){
		assertThat("qkrqhdtn3", is(equalTo(jasyptTest.getPropertiesTestValue())));
		System.out.println(jasyptTest.getPropertiesTestValue());
	}
}
