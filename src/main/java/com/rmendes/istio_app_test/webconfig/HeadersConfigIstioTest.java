package com.rmendes.istio_app_test.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class HeadersConfigIstioTest implements WebMvcConfigurer{
	
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/")
		.allowedOrigins("")
		.allowedHeaders("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization", "X-Requested-With", "x-canal", "x-b3-traceid", "x-b3-spanid", "x-b3-sampled", "x-request-id")
		.allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
		.maxAge(3600);
	}
	
	   @Bean
	    public WebMvcConfigurer corsConfig() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry
	                        .addMapping("/**")
	                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
	                        .allowedHeaders("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization", "X-Requested-With","x-b3-traceid", "x-b3-spanid", "x-b3-sampled", "x-request-id")
	                        .allowedOrigins("*");
	            }
	        };
	    }


}
