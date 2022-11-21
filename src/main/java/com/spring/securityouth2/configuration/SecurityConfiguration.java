package com.spring.securityouth2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	/**
	 * oauth2 is an authorization protocol
	 * 
	 * Agenda is to get user info from third party resource ex: google/github from client application
	 * 
	 * Below are the parties involved while communicating
	 * 
	 * user : resource owner
	 * client: client application used by user
	 * authorization server : third party server ex: google authorization server
	 * resource server : server where resource located ex: google contacts
	 * 
	 * here client application can access users google contacts using oauth2
	 * 
	 * client requests for google contacts access to googles authorization server, google prompts authentication page to user
	 * then google prompts a dialog that client is trying to access google contacts do you wish to allow
	 * 
	 * if allowed google sends an authentication code(Authentication Grant Type) to client
	 * then client used authentication code to get access token from google
	 * 
	 * When client gets access token it can access google contacts over a session
	 * 
	 * @param http
	 * @return
	 * @throws Exception
	 */

	@Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().oauth2Login();
        return http.build();
    }

}
