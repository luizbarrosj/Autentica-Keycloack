package com.sunny.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
@Table(name = "c_livros")
public class BLivros implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name = "Descricao",length = 60, nullable = false)
	private String nome;
	
	 @ManyToOne
	 @JoinColumn(name = "colecao_id")
	  private BColecao colecao;
	 
  
	
	 @ManyToMany(mappedBy = "livros")
	 private List<BGenero> generos = new ArrayList<>();
	
	
	
	
	/*@OneToMany (mappedBy = "livros")
	private List<BColecao> colecao;
	 
	@ManyToMany
	@JoinTable(name = "R_LivrosXGenero",
	uniqueConstraints=@UniqueConstraint(columnNames = {"IDGenero","IDLivro"}),
	joinColumns = @JoinColumn(name="IDLivro"),
	inverseJoinColumns = @JoinColumn(name="IDGenero"))
	private List<BGenero> genero;*/





public BLivros() {
		
		
	}
	


	



	public BColecao getColecao() {
	return colecao;
}
 






public void setColecao(BColecao colecao) {
	this.colecao = colecao;
}







	public List<BGenero> getGeneros() {
	return generos;
}

public void setGeneros(List<BGenero> generos) {
	this.generos = generos;
}

	public BLivros(Integer id, String nome) {
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
		BLivros other = (BLivros) obj;
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
