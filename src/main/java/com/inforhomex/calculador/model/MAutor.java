package com.inforhomex.calculador.model;

import java.io.Serializable;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import com.inforhomex.calculador.entity.Autor;


public class MAutor implements Serializable,Comparable<MAutor>, Comparator<MAutor> {

	private static final long serialVersionUID = 25L;

	private Long id;

	private String nombre;
	private String apellido;
	private List<MLibro> libros;

	public MAutor(){
		libros = new ArrayList<>();
	}
	

    public MAutor(Autor autor){
        this.id=autor.getId();
        this.nombre = autor.getNombre();
        this.apellido = autor.getApellido();
	this.libros = autor.getLibros();
    }
    
    public MAutor(Long id, String nombre, String apellido){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<MLibro> getLibros() {
		return libros;
	}

	public void setLibros(List<MLibro> libros) {
		this.libros = libros;
	}

	@Override
    public int compare(MAutor autor1, MAutor autor2) {
        return Long.compare(autor1.getId() , autor2.getId());
    }

	@Override
    public int compareTo(MAutor autor) {
        return this.nombre.compareTo(autor.nombre);
	}
	
	@Override 
	public String toString(){
		if(libros.size() == 0){
			return "MAutor{id: "+id+",nombre:"+nombre+", apellido:"+apellido+"}";
		}
		return "MAutor{id: "+id+",nombre:"+nombre+", apellido:"+apellido+", libros: "+libros.toString()+"}";
	}
	
}
