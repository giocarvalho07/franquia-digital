package com.franquia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Estoque implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_estoque")
	private String nome_estoque;
	
	@OneToMany
	@JoinColumn(name = "id_estoque")
	private List<Marca> marcas;
	
	
	public Estoque() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_estoque() {
		return nome_estoque;
	}

	public void setNome_estoque(String nome_estoque) {
		this.nome_estoque = nome_estoque;
	}
	
	

	// get set do is_estoque
	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", nome_estoque=" + nome_estoque + ", marcas=" + marcas +
			"]";
	}

	public Estoque(Long id, String nome_estoque, List<Marca> marcas) {
		super();
		this.id = id;
		this.nome_estoque = nome_estoque;
		this.marcas = marcas;
	}


}
