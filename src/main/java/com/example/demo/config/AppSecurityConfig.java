package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity

public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	
	//Spring security default login form configuration
	@Autowired
	private UserDetailsService userDetailService;
	@Bean
	AuthenticationProvider authProvider() {
		
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		
		return provider;
	}
	
	
	//custom login page configuration
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		    .csrf().disable()
		    .authorizeRequests().antMatchers("/login").permitAll()
		    .anyRequest().authenticated()
		    .and()
		    .formLogin()
		    .loginPage("/login").permitAll()
		    .and()
		    .logout().invalidateHttpSession(true)
		    .clearAuthentication(true)
		    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		    .logoutSuccessUrl("/logout-sucess").permitAll();
		   
	}
	
	
	
	

	
	

}
