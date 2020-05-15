package com.hacra.wss.common.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hacra.wss.common.interceptor.LoginInterceptor;

/**
 * WebMvcConfig
 * 
 * @author Hacra
 * @version 2020/05/14
 */
public class WebMvcConfig implements WebMvcConfigurer {
	
	/**
	 * 注册登录拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LoginInterceptor interceptor = new LoginInterceptor();
		registry.addInterceptor(interceptor).addPathPatterns("/**")
			.excludePathPatterns("/login/**", "/image/**", "/static/**");
	}
}
