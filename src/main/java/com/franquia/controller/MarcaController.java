package com.franquia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.franquia.model.Estoque;
import com.franquia.model.Marca;
import com.franquia.service.EstoqueService;
import com.franquia.service.MarcaService;

@Controller
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private EstoqueService estoqueService;
	
	@GetMapping("/marca")
	public ModelAndView postMarca() {
		ModelAndView model = new ModelAndView("franqueador/marca/criarMarca");
		model.addObject("marca", new Marca());
		model.addObject("marcas", marcaService.listarMarca());
		model.addObject("estoques",estoqueService.listarEstoque());
		return model;
	}

	
	@PostMapping("/marca")
	public ModelAndView postCriarMarca(Marca marca, Estoque estoque) {
		marcaService.criarMarca(marca);
		estoqueService.criarEstoque(estoque);
		ModelAndView model = new ModelAndView("franqueador/marca/criarMarca");
		Iterable<Marca> marcas = marcaService.listarMarca();
		Iterable<Estoque> estoques = estoqueService.listarEstoque();
		model.addObject("marcas", marcas);
		model.addObject("estoques", estoques);
		model.addObject("mensagemCadastrada", "Marca adicionada com sucesso");
		return model;
	}
	
	@GetMapping("/ver-marca")
	public ModelAndView getMarca() {
		ModelAndView model = new ModelAndView("franqueador/marca/marca");
		Iterable<Marca> marcas = marcaService.listarMarca();
		model.addObject("marcas", marcas);
		return model;
	}
	

    @GetMapping("/editar-marca")
    public ModelAndView editarMarca(@RequestParam Long id,  Estoque estoque) {
        ModelAndView model = new ModelAndView("franqueador/marca/editarMarca");
        Marca marca = marcaService.idMarca(id);
        model.addObject("marca",  marca);
        model.addObject("estoques", estoqueService.listarEstoque());
        model.addObject("mensagemEditada", "Marca será editada");
        return model;
    }
    
    
    @GetMapping("/deletar-marca") 
    public String removerAluno(@RequestParam Long id){
        Marca marca = marcaService.idMarca(id);
        marcaService.deletarMarca(marca);
        return "redirect:/ver-marca";
    }

}
