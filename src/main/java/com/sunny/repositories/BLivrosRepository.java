package com.sunny.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunny.domain.BLivros;

@Repository

public interface BLivrosRepository  extends JpaRepository<BLivros, Integer>{
	
	

}
