package br.com.springboot.curso_jdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
	
	@GetMapping ("/")
	private String home(Model model) {
		return "home";
	}
	
	@GetMapping ("/home")
	private String voltar(Model model) {
		return "home";
	}
	
	@GetMapping ("/index")
	private String clientes(Model model) {
		return "index";
	}
	
	@GetMapping ("/index2")
	private String apolice(Model model) {
		return "index2";
	}
}
