package com.sunny.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	  @GetMapping(value = "/index")
	    String index(Model model) {
	        return "index";
	    }

	    @GetMapping(value = "/dashboard")
	    String dashboard(Model model) {
	        return "view-names";
	    }
	    
	    
	    
	    
	    
	    
		@RequestMapping("/Biblioteca")
		public String getResource() {
			
	    	 return "protected resource";
		}
		
}
