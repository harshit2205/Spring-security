package com.example.springSecurityDemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringAuthConfigurer extends WebSecurityConfigurerAdapter{
	 @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Harshit").password(getPasswordEncoder().encode("password")).roles("ADMIN").and()
		//idea behind password encoder is to prevent from malicious attacks of the hackers in order to encode and save the password
		.passwordEncoder(getPasswordEncoder());
		//here you can also use nop password encoder for plain text password save which would not be ideal though as given below comment:
		//.passwordEncoder(NoOpPasswordEncoder.getInstance());
		// now you don't have to encode your password
	}
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	}
	
	private PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
