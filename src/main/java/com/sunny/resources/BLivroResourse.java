package com.sunny.resources;

import java.net.URI;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.sunny.domain.BLivros;
import com.sunny.services.BLivrosServise;

@RestController
@RequestMapping(value="/livros")
public class BLivroResourse {
	
	@Autowired
	private BLivrosServise service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find (@PathVariable Integer id) {
		
		BLivros obj = service.find(id);
		return  ResponseEntity.ok(obj);
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody BLivros obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build(); 
	} 
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void>update(@RequestBody BLivros obj, @PathVariable Integer id){
		obj.setId(id);
		obj=service.update(obj);
		return ResponseEntity.noContent().build();
		
		
		
	}
	
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<?> delete (@PathVariable Integer id) {
		
		
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
}  
