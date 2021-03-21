package com.franquia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.franquia.service.EstoqueService;

@Controller
public class EstoqueController {
	
	@Autowired
	private EstoqueService estoqueService;
	
	@GetMapping("/estoque")
	public String estoqueHome() {
		return "franqueador/estoque";
	}

}
