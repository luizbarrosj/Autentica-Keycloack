package com.sunny.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "c_colecao")
public class BColecao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "Descricao",length = 60,nullable = false)
	private String nome;
	
	
	@OneToMany(mappedBy = "colecao")
	private List<BLivros> livros= new ArrayList<>();
	
	 
		 
	
	
	
	

	public BColecao() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public BColecao(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BColecao other = (BColecao) obj;
		return Objects.equals(id, other.id);
	}

}
