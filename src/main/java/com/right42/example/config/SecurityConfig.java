package com.right42.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
		.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/home")
					.hasAuthority("SCOPE_read")
				.anyRequest().authenticated()
		.and()
			.oauth2ResourceServer()
				.jwt()
		;
	}
}
