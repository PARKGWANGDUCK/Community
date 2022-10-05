package com.simple.playdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.simple.playdata.interceptor.UserAuthHandler;

@Configuration //스프링 설정파일로 사용
public class WebConfig implements WebMvcConfigurer {

	//인터셉터 빈 등록
	@Bean
	public UserAuthHandler userAuthHandler() {
		
		return new UserAuthHandler(); 
	}

	//인터셉터 추가
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor( userAuthHandler() )
				.addPathPatterns("/main")
				.addPathPatterns("/user/**") //인터셉터 경로 추가
				.addPathPatterns("/practice/**") //인터셉터 경로 추가
				.addPathPatterns("/notice/**")
				
				.excludePathPatterns("/user/login") //인터셉터 경로 제외
				.excludePathPatterns("/user/join");
		
		//다른역활을 하는 인터셉터가 있다면 추가
//		registry.addInterceptor(인터셉터 빈)
				
	}
	
	
}
