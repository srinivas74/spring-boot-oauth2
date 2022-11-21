package com.spring.securityouth2.api;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPI {
	
	
	/**
	 * @param principal this api is protected user should be authenticated, if filters authenticates the user then request is forwarded to this controller with principal which contains authenticated user details
	 * @return
	 */
	@GetMapping("/")
	public String welcome(Principal principal) {
		return "Hello User :"+ principal.getName();
	}

}
