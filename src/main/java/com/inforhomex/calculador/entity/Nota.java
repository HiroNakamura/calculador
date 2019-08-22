package com.inforhomex.calculador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Comparator;

@Entity(name="Nota")
@Table(name="notas")
public class Nota implements Serializable,Comparator<Nota>,Comparable<Nota>{
    
    private static final long serialVersionUID = 21L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String nombre;
    private String titulo;
    private String contenido;

    public Nota(){}


    public Nota(Long id,String nombre, String titulo, String contenido){
        this.id = id;
        this.nombre=nombre;
        this.titulo=titulo;
        this.contenido=contenido;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public int compareTo(Nota nota) {
        return this.titulo.compareTo(nota.titulo);
    }

    @Override
    public int compare(Nota nota1, Nota nota2) {
        return Long.compare(nota1.getId() , nota2.getId());
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nota nota = (Nota) o;

        return id != null ? id.equals(nota.id) : nota.id == null;
    }

    @Override
    public String toString(){
        return "Nota{ id = "+id+", nombre = "+nombre+", tiulo = "+titulo+", contenido = "+contenido+"}";
    }

}
