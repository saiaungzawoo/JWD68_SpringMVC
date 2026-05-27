package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.StudentBean;

@Controller
public class StudentController {
	
	//form input view
	
	//url can be any name
	@GetMapping("/student-create")
	public ModelAndView showForm () {
		
		return new ModelAndView("student-create", "studObj", new StudentBean());
		
		
	}
	
	//form output view
	
	@PostMapping("/student-create")
	public String createStudent(@Validated  @ModelAttribute("studObj")StudentBean obj, BindingResult br,  Model m) {
		
		if(br.hasErrors()) {
			return "student-create";
		}
		
		m.addAttribute("studObj", obj);
		
		return "student-info";
		
	}
	
	
	@ModelAttribute("framework_list")
	  public List<String> getAllFrameworks(){
	    List<String> lst= new ArrayList<>();
	    lst.add("Spring Framework");
	    lst.add("Bootstrap");
	    lst.add("Collection Framework");
	    return lst;
	  }
	
	@ModelAttribute("favNumber_list")
	public List<Integer> getAllNumbers(){
		List<Integer> lst= new ArrayList<>();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		lst.add(4);
		
		return lst;
		
		
	
	}	
		
		
	@ModelAttribute("countryList")	
	public Map<String, String> getAllCountries(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("MM", "Myanmar");
		map.put("UK", "United Kingdom");
		map.put("JP", "Japan");
		
		
		return map;
		
	}
	
	@ModelAttribute("skillList")	
	public List<String> getAllSkills(){
		
		List<String> skList = new ArrayList<String>();
		
		skList.add("Java");
		skList.add("Spring");
		skList.add("Boostrap");
		
		
		return skList;
		
	}
	
}
	
	
	
	
	
