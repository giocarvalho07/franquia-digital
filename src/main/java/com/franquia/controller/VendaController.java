package com.franquia.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.franquia.model.Produto;
import com.franquia.model.Venda;
import com.franquia.service.ProdutoService;
import com.franquia.service.VendaService;

@Controller
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/venda")
	public String postVenda() {
		return "franqueador/venda/criarVenda";
	}
	
	@PostMapping("/venda")
	public ModelAndView postCrairVenda(Venda venda) {
		vendaService.criarVenda(venda);
		ModelAndView model = new ModelAndView("franqueador/venda/criarVenda");
		Iterable<Venda> vendas = vendaService.listarVenda();
		model.addObject("vendas", vendas);
		model.addObject("mensagemCadastrada", "Venda salvo com sucesso");
		return model;
	}

	@GetMapping("/ver-venda")
	public ModelAndView getVenda() {
		ModelAndView model = new ModelAndView("franqueador/venda/venda");
		Iterable<Venda> vendas = vendaService.listarVenda();
		model.addObject("vendas", vendas);
		return model;
	}
	
	
	@GetMapping("/editar-venda")
	public ModelAndView editarProduto(@RequestParam Long codigo_venda) {
		ModelAndView model = new ModelAndView("franqueador/venda/editarVenda");
		Venda venda = vendaService.idVenda(codigo_venda);
		model.addObject("venda", venda);
		model.addObject("vendas", vendaService.listarVenda());
		model.addObject("mensagemEditada", "Venda será editado");
		return model;
	}
	
	
	@PostMapping("/adicionar-produto-venda")
	public String postVendaProduto(Produto produto, @RequestParam Long codigo_venda) {
		Venda venda = vendaService.idVenda(codigo_venda);
		produto = produtoService.idProduto(produto.getId());
		venda.getProdutos().add(produto);
		vendaService.criarVenda(venda);
		return "redirect:/adicionar-produto-venda/" + codigo_venda ;
	}
	
	
	
	@GetMapping("/adicionar-produto-venda/{codigo_venda}")
	public ModelAndView getVendaProduto(@PathVariable(name = "codigo_venda") Long codigo_venda) {
		ModelAndView model = new ModelAndView("franqueador/venda/continuarVenda");
		Venda venda = vendaService.idVenda(codigo_venda);
		model.addObject("venda", venda);
		model.addObject("vendas", vendaService.listarVenda());
		model.addObject("mensagemEditada", "Venda será editado");
		
		List<Produto> produtoAssociado = produtoService.listarProduto();
		produtoAssociado.removeAll(venda.getProdutos());
		model.addObject("produtos", produtoAssociado);
		return model;
	}
	
	
	@GetMapping("/detalhe-produto-venda/{codigo_venda}")
	public ModelAndView detalheProd(@PathVariable("codigo_venda") Long codigo_venda) {
		ModelAndView model = new ModelAndView("franqueador/venda/checkoutVenda");
		Venda venda = vendaService.idVenda(codigo_venda);
		model.addObject("venda", venda);
		model.addObject("vendas", vendaService.listarVenda());
		model.addObject("mensagemEditada", "Venda será editado");
		
		List<Produto> produtoAssociado = produtoService.listarProduto();
		produtoAssociado.removeAll(venda.getProdutos());
		model.addObject("produtos", produtoAssociado);
		return model;
	}
	

}
