package com.inforhomex.calculador.model;

import java.io.Serializable;
import java.util.Comparator;
import com.inforhomex.calculador.entity.Libro;


public class MLibro implements Serializable,Comparable<MLibro>, Comparator<MLibro>{

	private static final long serialVersionUID = 15L;


	private Long id;

	private String titulo;
	private String isbn;

	private MAutor autor;

    public MLibro(){
		autor = new MAutor();
	}
    
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
	

	public MAutor getAutor() {
		return autor;
	}


	public void setAutor(MAutor autor) {
		this.autor = autor;
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

	@Override
    public int compareTo(MLibro libro) {
        return this.titulo.compareTo(libro.titulo);
	}
	
	@Override
    public int compare(MLibro libro1,MLibro libro2) {
        return Long.compare(libro1.getId() , libro2.getId());
	}
	
	@Override 
	public String toString(){
		if(autor == null){
			return "Libro{id:"+id+", titulo:"+titulo+",isbn:"+isbn+"}";
		}
		return "Libro{id:"+id+", titulo:"+titulo+",isbn:"+isbn+", autor: "+autor+"}";
	}

	
}