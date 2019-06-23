package com.inforhomex.calculador.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@CrossOrigin("*")
@RestController
@RequestMapping("/curso")
public class CursoRestController{

	//http://localhost:8090/curso/index
	@GetMapping("/index")
	public String index(){
		return new String(LocalDateTime.now()+"; Bienvenidos al curso Spring Boot, MongoDb y Javascript");
	}

	

}
