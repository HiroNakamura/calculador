package com.inforhomex.calculador.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id; 
import javax.persistence.Table; 
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
 
@Entity(name="Pais")
@Table(name="paises")
public class Pais implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
    private Integer id;
    private String nombre;
    private String continente;
    private String simbolo;

    public Pais(){}

    public Pais(Integer id,String nombre,String continente,String simbolo){
        super();
        this.id = id;
        this.nombre = nombre;
        this.continente = continente;
        this.simbolo = simbolo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    public String getContinente() {
        return continente;
    }

  
    public void setContinente(String continente) {
        this.continente = continente;
    }

  
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString(){
        return "Pais{id = "+id+", nombre = "+nombre+", continente = "+continente+", simbolo = "+simbolo+"}";
    }

}