package com.hacra.wss.modules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hacra.wss.common.util.SpringContextHolder;

/**
 * WSS
 * 
 * @author Hacra
 * @date 2020/05/11
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public SpringContextHolder getSpringContextHolder() {
		return new SpringContextHolder();
	}
}
