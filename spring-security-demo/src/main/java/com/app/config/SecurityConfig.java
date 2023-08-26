package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration //to tell SC below class contain @Bean annotations methods
@EnableWebSecurity//to enable spring security support
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override//For authentication
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// to enable IN memory Authentication
		auth.inMemoryAuthentication()
		.withUser("Rama").password(passwordEncoder().encode("12345")).roles("ADMIN")
		.and()
		.withUser("Mihir").password(passwordEncoder().encode("12345")).roles("CUSTOMER");
	}

	@Override//for authorization
	protected void configure(HttpSecurity http) throws Exception {
		// to customize authorization rules based upon roles
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/customer/**").hasAnyRole("CUSTOMER","ADMIN")
		.antMatchers("/admin").hasRole("ADMIN")
		.and()
		.formLogin() //enable for login:supplies to brower  clinet  loin n logout feature
		.and()
		.httpBasic();//enables basic auth
	}
	
	//configure password encode bean: vendor=bencrypt encoder
	@Bean
	public PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}

}
