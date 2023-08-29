package com.jsp.pmapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication

public class PmappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmappApplication.class, args);
	}
	
	@Configuration
	public  class webConfig implements WebMvcConfigurer{
	    public void addCorsMappings(CorsRegistry registry) {
	    	registry.addMapping("/**")
	    	.allowedOrigins("*")
	    	.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH");
//	    	.allowedHeaders("*")
//            .exposedHeaders("Authorization")
//            .allowCredentials(true);
//	    	 .maxAge(3600);
	    	
            
	    	
               
	    }
	}

}
