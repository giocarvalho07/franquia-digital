package com.franquia.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Estoque implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_estoque")
	private String nomeEstoque;
	

	public Estoque() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEstoque() {
		return nomeEstoque;
	}

	public void setNomeEstoque(String nomeEstoque) {
		this.nomeEstoque = nomeEstoque;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", nomeEstoque=" + nomeEstoque + "]";
	}

	public Estoque(Long id, String nomeEstoque) {
		super();
		this.id = id;
		this.nomeEstoque = nomeEstoque;
	}

}
