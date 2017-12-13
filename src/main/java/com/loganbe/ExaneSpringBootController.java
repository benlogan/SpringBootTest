package com.loganbe;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Controller
@EnableAutoConfiguration
public class ExaneSpringBootController {

	final static String AUTH_HEADER = "TzWJ!UD9y7s8gx54=gn*YnVKUy8mC!g%a^W+myfp";
	
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello Exane World! Nothing here!";
    }
	
    @RequestMapping("/AuthoriseUser")
    @ResponseBody
    String authoriseUser(String userEmailAddress) {
    	
    	// proxy to https://cube.exane.com/service/vendors/checkuser/EMAIL/
    	String crmService = "https://cube.exane.com/service/vendors/checkuser/";
    	crmService += userEmailAddress + "/";
    	
    	System.out.println("Proxying : " + crmService);
    	
		RestTemplate restTemplate = new RestTemplate();
		// we can't do this, as we need to set the auth/header
        //CheckUser checkUser = restTemplate.getForObject("https://cube.exane.com/service/vendors/checkuser/ludovic.tenant@exane.com/", CheckUser.class);
        
		HttpHeaders headers = new HttpHeaders();
		//headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		//headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Authorization", AUTH_HEADER);

		//HttpEntity<RestRequest> entityReq = new HttpEntity<RestRequest>(request, headers);
		HttpEntity<String> entityReq = new HttpEntity<String>("parameters", headers);
		
        ResponseEntity<CheckUser> respEntity = restTemplate
        	    .exchange(crmService, HttpMethod.GET, entityReq, CheckUser.class);
        
        System.out.println("CRM Response : " + respEntity.toString());
    	
        // FIXME we shouldn't be passing the input email back - injection risk etc
        
        ExaneResponse response = new ExaneResponse();
        response.setAuthorised(respEntity.getBody().isExaneResearchAccess());
        response.setEmail(userEmailAddress);
        response.setContent("http://google.com");
        
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(response);
    	//String jsonResponse =	"{\"authorised\": \"" + respEntity.getBody().isExaneResearchAccess() + "\",\"email\":\"" + userEmailAddress + "\",\"content\":\"http://google.com\"}";

        System.out.println("JSON Response : " + jsonResponse);
    	return jsonResponse;
    }
    
	public static void main(String[] args) {
		System.out.println("Exane Spring Boot Testing (starting)");

		SpringApplication.run(ExaneSpringBootController.class, args);
        
        System.out.println("Exane Spring Boot Testing (started)");
	}

}