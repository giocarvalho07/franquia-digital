package com.franquia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquia.model.Venda;
import com.franquia.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public void criarVenda(Venda venda) {
		vendaRepository.save(venda);
	}
	
	public void deletarVenda(Venda venda) {
		vendaRepository.delete(venda);
	}
	
	public Iterable<Venda> listarVenda(){
		return vendaRepository.findAll();
	}
	
	public Venda idVenda(Long codigo_venda) {
		return vendaRepository.findById(codigo_venda).get();
	}

}
