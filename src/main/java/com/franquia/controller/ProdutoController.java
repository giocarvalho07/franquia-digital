package com.franquia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.franquia.model.Marca;
import com.franquia.model.Produto;
import com.franquia.service.MarcaService;
import com.franquia.service.ProdutoService;

@Controller
public class ProdutoController {
	

	@Autowired
	private MarcaService marcaService;

	@Autowired 
	private ProdutoService produtoService;
	
	@GetMapping("/produto")
	public ModelAndView postProduto() {
		ModelAndView model = new ModelAndView("franqueador/produto/criarProduto");
		model.addObject("produto", new Produto());
		model.addObject("produtos", produtoService.listarProduto());
		model.addObject("marcas", marcaService.listarMarca());
		return model;
	}
	
	@PostMapping("/produto")
	public String postCriarProduto( @ModelAttribute Produto produto, Marca marca )  {
		marcaService.criarMarca(marca);
		produtoService.criarProduto(produto);
		ModelAndView model = new ModelAndView("franqueador/produto/criarProduto");
		Iterable<Marca> marcas = marcaService.listarMarca();
		Iterable<Produto> produtos = produtoService.listarProduto();
		
		
		model.addObject("produtos", produtos);
		model.addObject("marcas", marcas);
		model.addObject("mensagemCadastrada", "Produto adicionada com sucesso");
		return "redirect:/produto";
	}
	
	@GetMapping("ver-produto")
	public ModelAndView getProdutos() {
		ModelAndView model = new ModelAndView("franqueador/produto/produto");
		Iterable<Produto> produtos = produtoService.listarProduto();
		model.addObject("produtos", produtos);
		return model;
	}
	
	@GetMapping("/deletar-produto")
	public String deleteProduto(@RequestParam Long id) {
		Produto produto = produtoService.idProduto(id);
		produtoService.deletarProduto(produto);
		return "redirect:/ver-produto";
	}
 
    

    
	@GetMapping("/editar-produto/{id}")
	public ModelAndView updateProduto(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("franqueador/produto/editarProduto");
		Produto produto = produtoService.idProduto(id);
        model.addObject("produto",  produto);
        model.addObject("marcas", marcaService.listarMarca());
		return model;
	}
	
	
	@GetMapping("/detalhe-produto/{id}")
	public ModelAndView detalheProd(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("franqueador/produto/detalheProduto");
		Produto produto = produtoService.idProduto(id);
        model.addObject("produto",  produto);
        model.addObject("marcas", marcaService.listarMarca());
		return model;
	}
    

	
	
}
