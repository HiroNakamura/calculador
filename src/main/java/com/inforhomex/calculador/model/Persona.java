package com.inforhomex.calculador.model;


public class Persona{

	private String nombre;
	private String apellido;
	private String telefono;

	public Persona(){
		
	}

	public Persona(String nombre, String apellido, String telefono){
		super();
		this.nombre=nombre;
		this.apellido=apellido;
		this.telefono=telefono;
	}


	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public String getApellido(){
		return apellido;
	}

	public void setApellido(String apellido){
		this.apellido = apellido;
	}

	public String getTelefono(){
		return telefono;
	}

	public void setTelefono(String telefono){
		this.telefono = telefono;
	}

	@Override
	public String toString(){
		return "Persona{nombre = "+nombre+",apellido = "+apellido+",telefono = "+telefono+"}";
	}	

}
