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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_venda")
	private Long codigo_venda;
	
	@DateTimeFormat(pattern="dd-MMM-YYYY")
	@Column(name = "data_venda")
	private String data_venda;
	
	@Column(name = "forma_pagamento")
	@Enumerated(EnumType.STRING)
	private FormaPagamento forma_pagamento;
	
	@Column(name = "hash_venda")
	private String hash_venda;
	
	public String getHash_venda() {
		return hash_venda;
	}

	public void setHash_venda(String hash_venda) {
		this.hash_venda = hash_venda;
	}


	public Venda() {
	}
	

	public Long getCodigo_venda() {
		return codigo_venda;
	}

	public void setCodigo_venda(Long codigo_venda) {
		this.codigo_venda = codigo_venda;
	}

	public String getData_venda() {
		return data_venda;
	}

	public void setData_venda(String data_venda) {
		this.data_venda = data_venda;
	}

	public FormaPagamento getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(FormaPagamento forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}


	// vendas
	@ManyToMany
	@JoinTable(
			name = "venda_produtos",
			uniqueConstraints = @UniqueConstraint(columnNames = {"id_produto","id_venda"}),
			joinColumns = @JoinColumn(name = "id_venda"),
			inverseJoinColumns = @JoinColumn(name = "id_produto")
			)
	private List<Produto> produtos;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	@Override
	public String toString() {
		return "Venda [codigo_venda=" + codigo_venda + ", data_venda=" + data_venda + ", forma_pagamento="
				+ forma_pagamento + ", hash_venda=" + hash_venda + ", produtos=" + produtos + "]";
	}

	public Venda(Long codigo_venda, String data_venda, FormaPagamento forma_pagamento, String hash_venda,
			List<Produto> produtos) {
		super();
		this.codigo_venda = codigo_venda;
		this.data_venda = data_venda;
		this.forma_pagamento = forma_pagamento;
		this.hash_venda = hash_venda;
		this.produtos = produtos;
	}

}
