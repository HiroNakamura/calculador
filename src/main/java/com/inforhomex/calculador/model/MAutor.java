package com.inforhomex.calculador.model;


import java.io.Serializable;

import com.inforhomex.calculador.entity.Autor;


public class MAutor implements Serializable{

	private static final long serialVersionUID = 25L;

	private Long id;

	private String nombre;
	private String apellido;

    public MAutor(){}

    public MAutor(Autor autor){
        this.id=autor.getId();
        this.nombre = autor.getNombre();
        this.apellido = autor.getApellido();
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
	
}