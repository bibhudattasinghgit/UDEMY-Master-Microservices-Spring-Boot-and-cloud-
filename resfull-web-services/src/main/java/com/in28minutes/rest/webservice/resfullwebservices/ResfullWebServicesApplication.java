package com.in28minutes.rest.webservice.resfullwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class ResfullWebServicesApplication {

	public static void main(String[] args) {
		System.out.println("Welll come to Spring Boot microservice..");
		System.out.println("Welll come to Spring Boot microservice GIT-1..");
		SpringApplication.run(ResfullWebServicesApplication.class, args);
	}
	
	@Bean
   public LocaleResolver localeResolver() {
		
  AcceptHeaderLocaleResolver sessionResolver=new AcceptHeaderLocaleResolver();
		sessionResolver.setDefaultLocale(Locale.US);
		return sessionResolver;
	}
	
	public ResourceBundleMessageSource messageSource() {
		
		ResourceBundleMessageSource source=new ResourceBundleMessageSource();
		source.setBasename("message");
		return source;
	}
}
