package com.inforhomex.calculador.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

import com.inforhomex.calculador.Mensajes;
import com.inforhomex.calculador.MensajesServicioImpl;
import com.inforhomex.calculador.model.MAutor;
import com.inforhomex.calculador.model.MLibro;
import com.inforhomex.calculador.service.IAutorService;
import com.inforhomex.calculador.service.ILibroService;

@CrossOrigin("*")
@RestController
@RequestMapping("/curso")
public class CursoRestController{

	@Autowired
	private MensajesServicioImpl mensajesServicioImpl;

	@Autowired
	@Qualifier("libroService")
	private ILibroService libroServiceImpl;

	@Autowired
	@Qualifier("autorService")
	private IAutorService autorServiceImpl;

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

	//http://localhost:8090/curso/mensaje/pt_PT
	@GetMapping("/mensaje/{idioma}")
	public Mensajes getMensajeOne(@PathVariable("idioma") String idioma){
		System.out.println("Idioma: "+idioma);
		return mensajesServicioImpl.getMensaje(idioma);
	}

	//http://localhost:8090/curso/libros
	@GetMapping("/libros")
	public List<MLibro> getLibros(){
		return libroServiceImpl.getLibrosAll();
	}

	//http://localhost:8090/curso/libros/1
	@GetMapping("/libros/{id}")
	public MLibro getLibro(@PathVariable Long id){
		return libroServiceImpl.findLibroById(id);
	}

	//http://localhost:8090/curso/autores
	@GetMapping("/autores")
	public List<MAutor> getAutores(){
		return autorServiceImpl.getAutoresAll();
	}

	//http://localhost:8090/curso/autores/1
	@GetMapping("/autores/{id}")
	public MAutor getAutor(@PathVariable Long id){
		return autorServiceImpl.findAutorById(id);
	}


}