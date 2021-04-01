package com.franquia.model;

public enum Categoria {
	
	ELETRONICOS("Eletronicos"),
	VESTUARIO("Vestuario"),
	BRINQUEDOS("Brinquedos"),
	BELEZA("Beleza"),
	AUTOPEÇAS("Auto-peças"),
	COMIDAS("Comidas"),
	BEBIDAS("Bebidas");
	
	private String categoria;
	// Atributo referente a model 


	private Categoria (String categoria) {
		this.categoria = categoria;
	}
	


}
