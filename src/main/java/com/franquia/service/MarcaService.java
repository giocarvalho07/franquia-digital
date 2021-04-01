package com.franquia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.franquia.model.Marca;
import com.franquia.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	public void criarMarca(Marca marca) {
		marcaRepository.save(marca);
	}
	
	public void deletarMarca(Marca marca) {
		marcaRepository.delete(marca);
	}
	
	public Iterable<Marca> listarMarca(){
		return marcaRepository.findAll();
	}
	
	public Marca idMarca(Long id) {
		return marcaRepository.findById(id).get();
	}

}
