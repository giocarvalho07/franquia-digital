package com.franquia.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Estoque implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_estoque")
	private String nome_estoque;

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

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", nome_estoque=" + nome_estoque + "]";
	}

	public Estoque() {
	}

	public Estoque(Long id, String nome_estoque) {
		super();
		this.id = id;
		this.nome_estoque = nome_estoque;
	}

	
}
