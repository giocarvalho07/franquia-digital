package com.franquia.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Produto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_produto")
	private String nome_produto;
	
	@Column(name = "tipo_produto")
	@Enumerated(EnumType.STRING)
	private TipoProduto tipo_produto;
	
	@Column(name = "quantidade_produto")
	private int quantidade_produto;

	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;
	
	@Column(name = "preco_produto")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal preco_produto;

	@Column(name = "hash_produto")
	private String hash_produto;
	

	public TipoProduto getTipo_produto() {
		return tipo_produto;
	}

	public void setTipo_produto(TipoProduto tipo_produto) {
		this.tipo_produto = tipo_produto;
	}

	public String getHash_produto() {
		return hash_produto;
	}

	public void setHash_produto(String hash_produto) {
		this.hash_produto = hash_produto;
	}

	public Produto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public int getQuantidade_produto() {
		return quantidade_produto;
	}

	public void setQuantidade_produto(int quantidade_produto) {
		this.quantidade_produto = quantidade_produto;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public BigDecimal getPreco_produto() {
		return preco_produto;
	}

	public void setPreco_produto(BigDecimal preco_produto) {
		this.preco_produto = preco_produto;
	}
	



	// vendas
	@ManyToMany
	@JoinTable(
			name = "venda_produtos",
			uniqueConstraints = @UniqueConstraint(columnNames = {"id_produto","id_venda"}),
			joinColumns = @JoinColumn(name = "id_produto"),
			inverseJoinColumns = @JoinColumn(name = "id_venda")
			)
	private List<Venda> vendas;


	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome_produto=" + nome_produto + ", tipo_produto=" + tipo_produto
				+ ", quantidade_produto=" + quantidade_produto + ", marca=" + marca + ", preco_produto=" + preco_produto
				+ ", hash_produto=" + hash_produto + ", vendas=" + vendas + "]";
	}

	
	
}
