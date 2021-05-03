package com.franquia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.franquia.model.Estoque;
import com.franquia.service.EstoqueService;
import com.franquia.service.MarcaService;
import com.franquia.service.ProdutoService;
import com.franquia.service.VendaService;

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
		return "franqueador/estoque/criarEstoque";
	}
	
	@PostMapping("/estoque")
	public ModelAndView postCriarEstoque(Estoque estoque) {
		estoqueService.criarEstoque(estoque);
		ModelAndView model = new ModelAndView("franqueador/estoque/criarEstoque");
		Iterable<Estoque> estoques = estoqueService.listarEstoque();
		model.addObject("estoques", estoques);
		model.addObject("mensagemCadastrada", "Estoque salvo com sucesso");
 		return model;
	}
	
	@GetMapping("/ver-estoque")
	public ModelAndView getEstoque() {
		ModelAndView model = new ModelAndView("franqueador/estoque/estoque");
		Iterable<Estoque> estoques = estoqueService.listarEstoque();
		model.addObject("estoques", estoques);
		return model;
	}
	
	@GetMapping("/deletar-estoque")
	public ModelAndView deleteEstoque(Long id) {
		Estoque estoque = estoqueService.idEstoque(id);
		estoqueService.deletarEstoque(estoque);
		ModelAndView model = new ModelAndView("redirect:/ver-estoque");
		Iterable<Estoque> estoques1 = estoqueService.listarEstoque();
		model.addObject("estoque", estoques1);
		return model;
		}

	
	
	
	@GetMapping("/editar-estoque")
    public ModelAndView updateEditarLivro(@RequestParam Long id){
    ModelAndView model = new ModelAndView("franqueador/estoque/editarEstoque");
    Estoque estoque = estoqueService.idEstoque(id);
    model.addObject("estoque",  estoque);
    model.addObject("mensagemEditada", "Estoque será editado");
    return model;
	}
}
