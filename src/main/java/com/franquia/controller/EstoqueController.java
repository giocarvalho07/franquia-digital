package com.franquia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.franquia.model.Estoque;
import com.franquia.service.EstoqueService;

@Controller
public class EstoqueController {
	
	@Autowired
	private EstoqueService estoqueService;

	@GetMapping("/home")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/estoque")
	public String postEstoque() {
		return "franqueador/criarEstoque";
	}
	
	@PostMapping("/estoque")
	public ModelAndView postCriarEstoque(Estoque estoque) {
		estoqueService.criarEstoque(estoque);
		ModelAndView model = new ModelAndView("franqueador/criarEstoque");
		Iterable<Estoque> estoques1 = estoqueService.listarEstoque();
		model.addObject("estoques", estoques1);
		model.addObject("mensagem", "Estoque salvo com sucesso");
 		return model;
	}
	
	@GetMapping("/ver-estoque")
	public ModelAndView getEstoque() {
		ModelAndView model = new ModelAndView("franqueador/estoque");
		Iterable<Estoque> estoques = estoqueService.listarEstoque();
		model.addObject("estoques", estoques);
		return model;
	}

	
}
