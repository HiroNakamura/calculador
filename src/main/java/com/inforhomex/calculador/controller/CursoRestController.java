package com.inforhomex.calculador.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.inforhomex.calculador.Mensajes;
import com.inforhomex.calculador.MensajesServicioImpl;
import com.inforhomex.calculador.entity.Autor;
import com.inforhomex.calculador.entity.Libro;
import com.inforhomex.calculador.model.MAutor;
import com.inforhomex.calculador.model.MLibro;
import com.inforhomex.calculador.service.IAutorService;
import com.inforhomex.calculador.service.ILibroService;

@CrossOrigin("*")
@RestController
@RequestMapping("/curso")
public class CursoRestController{

	private static final Logger LOG = LoggerFactory.getLogger(CursoRestController.class); 

	@Value("${programador.aplicacion}")
    private String nombre;

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
		LOG.info("Has entrado a http://localhost:8090/curso/index");
		LOG.info("Nombre aplicación: "+nombre);
		return new String(LocalDateTime.now()+"; Bienvenidos al curso Spring Boot, MongoDb y Javascript: "+nombre);
	}

	//http://localhost:8090/curso/mensajes
	@GetMapping("/mensajes")
	public List<Mensajes> getMensajes(){
		LOG.info("Has entradao a http://localhost:8090/curso/mensajes");
		return mensajesServicioImpl.getTodo();
	}

	//http://localhost:8090/curso/mensaje/pt_PT
	@GetMapping("/mensaje/{idioma}")
	public Mensajes getMensajeOne(@PathVariable("idioma") String idioma){
		System.out.println("Idioma: "+idioma);
		LOG.info("Has entrado a http://localhost:8090/curso/mensaje/"+idioma);
		return mensajesServicioImpl.getMensaje(idioma);
	}

	//http://localhost:8090/curso/libros
	@GetMapping("/libros")
	public List<MLibro> getLibros(){
		LOG.info("Has entrado a http://localhost:8090/curso/libros");
		return libroServiceImpl.getLibrosAll();
	}

	//http://localhost:8090/curso/libros/1
	@GetMapping("/libros/{id}")
	public MLibro getLibro(@PathVariable Long id){
		LOG.info("Has entrado a http://localhost:8090/curso/libros/"+id);
		return libroServiceImpl.findLibroById(id);
	}

	//http://localhost:8090/curso/libros/create
	@PostMapping("/libros/create")
	@ResponseBody
	public void createLibro(@RequestBody Libro libro){
		String titulo = libro.getTitulo();
		String isbn = libro.getIsbn();
		Long autor_id = libro.getAutor().getId();
		LOG.info("Has entrado a http://localhost:8090/curso/libros/create");
		LOG.info(libro.toString());
		libroServiceImpl.createLibro(titulo, isbn, autor_id);
	}

	//http://localhost:8090/curso/libros/delete/1
	@DeleteMapping("/libros/delete/{id}")
	@ResponseBody
	public void deleteLibro(@PathVariable Long id){
		LOG.info("Has entrado a http://localhost:8090/curso/libros/delete/"+id);
		libroServiceImpl.deleteLibro(id);
	}

	//http://localhost:8090/curso/libros/update/1
	@PutMapping("/libros/update/{id}")
	@ResponseBody
	public void updateLibro(@PathVariable("id") Long id,@RequestBody Libro libro){
		LOG.info("Has entrado a http://localhost:8090/curso/libros/update/"+id);
		MLibro mlibro = new MLibro(libro);
		if(libroServiceImpl.findLibroById(mlibro.getId()) !=null){
			LOG.info("Existe el libro a editar!!");
			libroServiceImpl.updateLibro(mlibro.getId(), mlibro.getTitulo(), mlibro.getIsbn(),mlibro.getAutor().getId());
		}
	}

	//http://localhost:8090/curso/autores
	@GetMapping("/autores")
	public List<MAutor> getAutores(){
		LOG.info("Has entrado a http://localhost:8090/curso/autores");
		return autorServiceImpl.getAutoresAll();
	}

	//http://localhost:8090/curso/autores/1
	@GetMapping("/autores/{id}")
	public MAutor getAutor(@PathVariable Long id){
		LOG.info("Has entrado a http://localhost:8090/curso/autores/"+id);
		return autorServiceImpl.findAutorById(id);
	}

	//http://localhost:8090/curso/autores/create
	@PostMapping("/autores/create")
	@ResponseBody
	public void createAutor(@RequestBody Autor autor){
		String nombre = autor.getNombre();
		String apellido = autor.getApellido();
		LOG.info("Has entrado a http://localhost:8090/curso/autores/create");
		LOG.info(autor.toString());
		autorServiceImpl.createAutor(nombre, apellido);
	}

	//http://localhost:8090/curso/autores/delete/1
	@DeleteMapping("/autores/delete/{id}")
	@ResponseBody
	public void deleteAutor(@PathVariable Long id){
		LOG.info("Has entrado a http://localhost:8090/curso/autores/delete/"+id);
		autorServiceImpl.deleteAutor(id);
	}

	//http://localhost:8090/curso/autores/update/1
	@PutMapping("/autores/update/{id}")
	@ResponseBody
	public void updateAutor(@PathVariable("id") Long id,@RequestBody Autor autor){
		LOG.info("Has entrado a http://localhost:8090/curso/autores/update/"+id);
		MAutor mautor = new MAutor(autor);
		if(autorServiceImpl.findAutorById(mautor.getId()) !=null){
			LOG.info("Existe el autor a editar!!");
			autorServiceImpl.updateAutor(mautor.getId(), mautor.getNombre(), mautor.getApellido());
		}
	}


}