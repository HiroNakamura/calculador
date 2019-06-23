package com.inforhomex.calculador.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/curso")
public class CursoRestController{

	//http://localhost:8090/curso/index
	@GetMapping("/index")
	public String index(){
		return "index";
	}

}
