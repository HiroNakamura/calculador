package com.inforhomex.calculador.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity(name="Autor")
@Table(name="autores")
public class Autor implements Serializable,Comparable<Autor>, Comparator<Autor> {

	private static final long serialVersionUID = 25L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;

	private String nombre;
	private String apellido;

	@OneToMany(mappedBy = "autor",
	cascade = CascadeType.ALL,
	orphanRemoval = true)
	private List<Libro> libros;

	public Autor(){
		this.libros = new ArrayList<>();
	}

	public Autor(Long id, String nombre, String apellido){
		super();
		this.id=id;
		this.nombre=nombre;
		this.apellido=apellido;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
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

	@Override
    public int compareTo(Autor autor) {
        return this.nombre.compareTo(autor.nombre);
	}
	
	@Override
    public int compare(Autor autor1, Autor autor2) {
        return Long.compare(autor1.getId() , autor2.getId());
    }

	@Override 
	public String toString(){
		if(libros.size() == 0){
			return "Autor{id: "+id+",nombre:"+nombre+", apellido:"+apellido+"}";
		}
		return "Autor{id: "+id+",nombre:"+nombre+", apellido:"+apellido+", libros: "+libros.toString()+"}";
	}
	
}
