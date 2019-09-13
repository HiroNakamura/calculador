package com.inforhomex.calculador.model;


public class Modelo{
    private String nombre;

    public Modelo(){}

    public Modelo(String nombre){
        this.nombre=nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Modelo { nombre = "+nombre+" }";
    }
}