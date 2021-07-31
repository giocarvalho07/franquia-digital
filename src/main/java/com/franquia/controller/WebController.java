package com.franquia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {

	@GetMapping("/home")
	public String index() {
		return "index";
	}
	

	@GetMapping("/sobre")
	public String sobre() {
		return "franqueador/web/sobreNos";
	}
	
	@GetMapping("/faq")
	public String faq() {
		return "franqueador/web/faq";
	}
	
	@GetMapping("/contato")
	public String contato() {
		return "franqueador/web/contato";
	}
	
}
