package com.inforhomex.calculador.entity;


import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Table(name="libros")
@Entity(name="Libro")
public class Libro implements Serializable,Comparable<Libro>, Comparator<Libro>{

	private static final long serialVersionUID = 15L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;

	private String titulo;
	private String isbn;

	public Libro(){
		this.autor = new Autor();
	}

	public Libro(Long id, String titulo, String isbn){
		super();
		this.id=id;
		this.titulo=titulo;
		this.isbn=isbn;
	}

	@JoinColumn(name="autor_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Autor autor;

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
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
    public int compareTo(Libro libro) {
        return this.titulo.compareTo(libro.titulo);
	}
	
	@Override
    public int compare(Libro libro1,Libro libro2) {
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
