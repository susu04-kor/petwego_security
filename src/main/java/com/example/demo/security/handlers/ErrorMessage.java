package com.example.demo.security.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ErrorMessage {

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		
		//위치 어디로..
		source.setBasenames("message/messages");
		source.setDefaultEncoding("UTF-8");
		source.setCacheSeconds(5);
		return source;
	}
}
