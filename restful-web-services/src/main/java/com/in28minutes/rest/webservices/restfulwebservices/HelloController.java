package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.helloworldbean.HelloWorldBean;

@RestController
public class HelloController {

	@GetMapping(value = "/hello-world")
	public String welcomecontroller()
	{
		return "Hello Resful Services Controller!!!";
	}
	
	@GetMapping(value = "/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(value = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name)
	{
		return new HelloWorldBean("Hello World, "+name);
	}
}
