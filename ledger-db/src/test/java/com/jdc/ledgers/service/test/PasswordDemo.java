package com.jdc.ledgers.service.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:/database-config.xml")
public class PasswordDemo {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void test() {
		
		System.out.println(passwordEncoder.encode("hello-spring"));
		System.out.println(passwordEncoder.encode("hello-java"));
		
	}
}
