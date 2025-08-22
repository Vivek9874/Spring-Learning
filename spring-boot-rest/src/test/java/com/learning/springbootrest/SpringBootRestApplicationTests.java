package com.learning.springbootrest;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import com.learning.springbootrest.SpringBootRestApplication; // Make sure this import matches your class's location

@SpringBootTest(classes = SpringBootRestApplication.class)
class SpringBootRestApplicationTests {
	@Test
	void contextLoads() {
	}
}