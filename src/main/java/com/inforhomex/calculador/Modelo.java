package com.inforhomex.calculador;

import org.springframework.stereotype.Component;

@Component
public class Modelo{

    private int id;
    private String nombre;
    
    public Modelo(){
        System.out.println("Objeto Modelo creado e inicializado");
    }

    public Modelo(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @Override 
    public String toString(){
        return "Modelo{ id= "+this.id+", nombre = "+this.nombre+"}";
    }

    public void compilar(){
        System.out.println("Compilando Modelo...");
    }
}