package com.franquia.model;

import javax.persistence.Column;

public enum TipoProduto {
	
	PRODUTO("produto"),
	SERVIÇO("serviço");

	@Column(name = "tipo_produto")
	private String tipo_produto;
	// Atributo referente a model 

	private TipoProduto(String tipo_produto) {
		this.tipo_produto = tipo_produto;
	}
	
}
