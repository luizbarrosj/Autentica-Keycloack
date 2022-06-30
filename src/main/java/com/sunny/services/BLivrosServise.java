package com.sunny.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sunny.domain.BLivros;
import com.sunny.repositories.BLivrosRepository;
import com.sunny.services.excepitions.DataIntegrityExeption;
import com.sunny.services.excepitions.ObejectNotFountExeption;

@Service
public class BLivrosServise {
	@Autowired
	private BLivrosRepository repo;
	
	
	public BLivros find( Integer id) {
		
		Optional<BLivros> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObejectNotFountExeption("Objeto não encontrado! Id: " + id
			 + ", Tipo: " + BLivros.class.getName()));
	}
	public BLivros insert(BLivros obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
	
	public BLivros update(BLivros obj) {
		find(obj.getId());
		return repo.save(obj);
		
		
	}
	
	public void delete(Integer id) {
		find(id);
		
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			
			throw new DataIntegrityExeption("Não é possivel excluir um livro que possui generos e categorias");
			
		}
		
	}

}
