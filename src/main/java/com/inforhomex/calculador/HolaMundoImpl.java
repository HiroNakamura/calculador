package com.inforhomex.calculador;


public class HolaMundoImpl implements HolaMundo{

    private String nombre;

    public String getNombre(){
        return nombre;
    }
    
    @Override
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @Override 
    public void imprimir(){
        System.out.println("Hola "+this.getNombre());
    }

}