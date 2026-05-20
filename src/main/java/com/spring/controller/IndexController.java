package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//github test

@Controller
public class IndexController {
	
	
	// "/index" is url
	//if it sees this url, call the method with that url
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndex() {
		
		return "redirect:message" ;
	}
	
	
	@GetMapping("/message")
	public String showMessage(Model m) {
		
		m.addAttribute("msg", "SpringMVC model");
		
		
		return "index";
		
		
	}
	
	
	 
	
	
	
	
	
	
	

}
