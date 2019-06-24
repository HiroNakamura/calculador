package com.inforhomex.calculador.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import com.inforhomex.calculador.Mensajes;
import com.inforhomex.calculador.MensajesServicioImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/curso")
public class CursoRestController{

	@Autowired
	private MensajesServicioImpl mensajesServicioImpl;

	//http://localhost:8090/curso/index
	@GetMapping("/index")
	public String index(){
		return new String(LocalDateTime.now()+"; Bienvenidos al curso Spring Boot, MongoDb y Javascript");
	}

	//http://localhost:8090/curso/mensajes
	@GetMapping("/mensajes")
	public List<Mensajes> getMensajes(){
		return mensajesServicioImpl.getTodo();
	}

}
