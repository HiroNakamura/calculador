package com.inforhomex.calculador.model;

import com.inforhomex.calculador.entity.Nota;
import java.io.Serializable;
import java.util.Comparator;

public class MNota implements Serializable,Comparator<MNota>,Comparable<MNota>{
    
    private static final long serialVersionUID = 19L;

    private Long id;
    private String nombre;
    private String titulo;
    private String contenido;

    public MNota(){}

    public MNota(Long id,String nombre, String titulo, String contenido){
        this.id = id;
        this.nombre=nombre;
        this.titulo=titulo;
        this.contenido=contenido;
    }

    public MNota(Nota nota){
        this.id = nota.getId();
        this.nombre=nota.getNombre();
        this.titulo=nota.getTitulo();
        this.contenido=nota.getContenido();
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
    public int compareTo(MNota nota) {
        return this.titulo.compareTo(nota.titulo);
    }

    @Override
    public int compare(MNota nota1, MNota nota2) {
        return Long.compare(nota1.getId() , nota2.getId());
    }

    @Override
    public String toString(){
        return "Nota{ id = "+id+", nombre = "+nombre+", tiulo = "+titulo+", contenido = "+contenido+"}";
    }

}
