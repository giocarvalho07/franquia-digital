package com.franquia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.franquia.model.Estoque;
import com.franquia.repository.EstoqueRepository;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	public void criarEstoque(Estoque estoque) {
		estoqueRepository.save(estoque);
	}
	
	public void deletarEstoque(Estoque estoque) {
		estoqueRepository.delete(estoque);
	}
	
	public Iterable<Estoque> listarEstoque(){
		return estoqueRepository.findAll();
	}
	
	public Estoque idEstoque(Long id) {
		return estoqueRepository.findById(id).get();
	}

}
