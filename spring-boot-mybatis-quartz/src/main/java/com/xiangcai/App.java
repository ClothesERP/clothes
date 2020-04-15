package com.xiangcai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.xiangcai.mapper")
@EnableScheduling         //开启定时任务注解
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
