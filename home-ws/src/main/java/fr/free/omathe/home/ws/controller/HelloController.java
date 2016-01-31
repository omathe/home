package fr.free.omathe.home.ws.controller;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {

	private static final Logger logger = Logger.getLogger(HelloController.class);
	

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello";
		
	}
	
}