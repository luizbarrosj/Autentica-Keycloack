package com.sunny.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "c_genero")
public class BGenero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "Descricao",nullable = false,length = 60)
    private String nome;
	

	@ManyToMany
	@JoinTable(name = "R_LivrosXGenero",
	joinColumns = @JoinColumn (name="IDGenero"),
	inverseJoinColumns = @JoinColumn(name="IDLivro")) 
	private List<BLivros> livros = new ArrayList<>();
	
	public BGenero() {
		
	}

	public BGenero(Integer id, String nome) {
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
		BGenero other = (BGenero) obj;
		return Objects.equals(id, other.id);
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
	
}
