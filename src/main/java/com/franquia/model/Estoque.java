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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Estoque implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_estoque")
	private String nome_estoque;
	
	@Column(name = "hash_estoque")
	private String hash_estoque;
	
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
		

	public String getHash_estoque() {
		return hash_estoque;
	}

	public void setHash_estoque(String hash_estoque) {
		this.hash_estoque = hash_estoque;
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
		return "Estoque [id=" + id + ", nome_estoque=" + nome_estoque + ", hash_estoque=" + hash_estoque + ", marcas=" + marcas +
			"]";
	}

	public Estoque(Long id, String nome_estoque, String hash_estoque, List<Marca> marcas) {
		super();
		this.id = id;
		this.nome_estoque = nome_estoque;
		this.marcas = marcas;
		this.hash_estoque = hash_estoque;
	}


}
