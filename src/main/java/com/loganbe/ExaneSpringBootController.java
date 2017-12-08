package com.loganbe;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class ExaneSpringBootController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello Ben's Exane World!";
    }
	
    @RequestMapping("/AuthoriseUser")
    @ResponseBody
    String authoriseUser(String userEmailAddress) {
    	
    	// proxy to https://cube.exane.com/service/vendors/checkuser/EMAIL/
    	String crmService = "https://cube.exane.com/service/vendors/checkuser/";
    	crmService += userEmailAddress + "/";
    	
    	System.out.println("proxying to " + crmService);
    	
        return "Authenticated " + userEmailAddress;
    }
    
	public static void main(String[] args) {
		System.out.println("SPRING BOOT TESTING");
		SpringApplication.run(ExaneSpringBootController.class, args);
	}

}