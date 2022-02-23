package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
		@RequestMapping("/")
		
		String message() {
			
		 return "home.jsp";
		}
		
		@RequestMapping("/login")
		String login() {
			
			return "login.jsp";
		}
		
		@RequestMapping("/logout-success")
		String logout() {
			
			return "logout.jsp";
		}
		
		@RequestMapping("/about")
		String about() {
			
			return "about.jsp";
		}
		
		
}



