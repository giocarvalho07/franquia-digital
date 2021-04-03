package com.franquia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.franquia.model.Produto;
import com.franquia.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void criarProduto(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public void deletarProduto(Produto produto) {
		produtoRepository.delete(produto);
	}
	
	public Iterable<Produto> listarProduto(){
		return produtoRepository.findAll();
	}
	
	public Produto idProduto(Long id) {
		return produtoRepository.findById(id).get();
	}

}
