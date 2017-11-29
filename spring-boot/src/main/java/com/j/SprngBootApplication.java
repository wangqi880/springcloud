package com.j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.j.mapper")
public class SprngBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprngBootApplication.class, args);
	}
}
