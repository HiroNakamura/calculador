package com.inforhomex.calculador.model;


import java.io.Serializable;

import com.inforhomex.calculador.entity.Libro;


public class MLibro implements Serializable{

	private static final long serialVersionUID = 15L;


	private Long id;

	private String titulo;
	private String isbn;

    public MLibro(){}
    
    public MLibro(Long id, String titulo, String isbn){
        this.id=id;
        this.titulo=titulo;
        this.isbn=isbn;
    }

    public MLibro(Libro libro){
        this.id=libro.getId();
        this.titulo =libro.getTitulo();
        this.isbn = libro.getIsbn();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	
}