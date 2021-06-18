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
	
}
