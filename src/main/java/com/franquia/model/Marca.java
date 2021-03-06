package com.franquia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Marca implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_marca")
	private String nome_marca;

	@Column(name = "tipo_produto")
	@Enumerated(EnumType.STRING)
	private TipoProduto tipo_produto;
	
	@Column(name = "categoria_marca")
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_estoque")
	private Estoque estoque;
	
	@Column(name = "hash_marca")
	private String hash_marca;
	
	
	public String getHash_marca() {
		return hash_marca;
	}

	public void setHash_marca(String hash_marca) {
		this.hash_marca = hash_marca;
	}

	public Marca() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_marca() {
		return nome_marca;
	}

	public void setNome_marca(String nome_marca) {
		this.nome_marca = nome_marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
	public TipoProduto getTipo_produto() {
		return tipo_produto;
	}

	public void setTipo_produto(TipoProduto tipo_produto) {
		this.tipo_produto = tipo_produto;
	}

	// get set do id_estoque
	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	
	// produto
	
	@OneToMany
	@JoinColumn(name = "id_marca")
	public List<Produto> produtos;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Marca(Long id, String nome_marca, TipoProduto tipo_produto, Categoria categoria, Estoque estoque,
			String hash_marca, List<Produto> produtos) {
		super();
		this.id = id;
		this.nome_marca = nome_marca;
		this.tipo_produto = tipo_produto;
		this.categoria = categoria;
		this.estoque = estoque;
		this.hash_marca = hash_marca;
		this.produtos = produtos;
	}

	
	
}
