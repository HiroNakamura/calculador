package com.inforhomex.calculador.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


public class Autor implements Serializable{

	private static final long serialVersionUID = 25L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
	private Long id;

	private String nombre;
	private String apellido;

	public Autor(){}

	



	
}