package com.franquia.service;

import java.util.List;
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
	
	public List<Produto> listarProduto(){
		return (List<Produto>) produtoRepository.findAll();
	}
	
	public Produto idProduto(Long id) {
		return produtoRepository.findById(id).get();
	}

}
