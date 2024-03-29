package com.in28minutes.rest.webservice.resfullwebservices.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		
		
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		
		return new HelloWorldBean("Hello World Bean..");
	}
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		
		
		return new HelloWorldBean(String.format("Hello World Bean..,%s",name));
	}
	
	
	@GetMapping(path="/hello-world-inter")
	public String helloWorldInternatiolization() {
		
		
		return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}

}
