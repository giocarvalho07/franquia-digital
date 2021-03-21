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
	
	@GetMapping("/estoque")
	public ModelAndView estoqueHome() {
		ModelAndView model = new ModelAndView("franqueador/estoque");
		model.addObject("estoque", estoqueService.listarEstoque());
		return model;
	}
	
	@PostMapping("/estoque")
	public String estoqueCadastrar(@ModelAttribute Estoque estoque) {
		estoqueService.criarEstoque(estoque);
		return "redirect:/estoque";
	}


}
