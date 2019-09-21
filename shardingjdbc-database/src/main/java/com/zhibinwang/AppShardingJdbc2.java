package com.zhibinwang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.zhibinwang.repository")
public class AppShardingJdbc2 {

	public static void main(String[] args) {
		SpringApplication.run(AppShardingJdbc2.class, args);
	}
}
