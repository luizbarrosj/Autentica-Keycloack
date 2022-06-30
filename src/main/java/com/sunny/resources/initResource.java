package com.sunny.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.domain.BLivros;

@RestController
@RequestMapping(value="/")
public class initResource {
	
	@GetMapping(value = "/")
	public String foi() {
		
		
		return  "OK";
	}

}
