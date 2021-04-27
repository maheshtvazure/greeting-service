package com.mahesh.greetingsservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!!";
	private  AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name",defaultValue = "Earth") String name) {
		System.out.println("Request received "+name);
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
	}

}
