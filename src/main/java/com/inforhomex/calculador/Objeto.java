package com.inforhomex.calculador;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@Scope(value = "prototype")
public class Objeto{

    private int id;
    private String nombre;
    private String valor;

    @Autowired
    private Modelo modelo;

    public Objeto(){
        this(1,"Alfa","El inicio del fin.");
        System.out.println("Objeto 'Objeto'  creado e inicializado");
    }

    public Objeto(int id, String nombre, String valor){
        this.id = id;
        this.nombre = nombre;
        this.valor = valor ;
    }

    public Objeto(Modelo modelo){
        this.modelo = modelo;
    }

    public Modelo getModelo(){
        return modelo;
    }

    public void setModelo(Modelo modelo){
        this.modelo = modelo;
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

    public String getValor(){
        return valor;
    }

    public void setValor(String valor){
        this.valor = valor;
    }

    @Override 
    public String toString(){
        String resultado = "";
        if(modelo == null){
            resultado = "Objeto{id = "+this.id+", nombre = "+this.nombre+", valor = "+this.valor+"}";
        }else{
            resultado = "Objeto{id = "+this.id+", nombre = "+this.nombre+", valor = "+this.valor+", modelo = "+this.modelo.toString()+"}";
        }
        return resultado;
    }

    public void mostrar(){
        this.modelo.compilar();
        System.out.println(this.toString());
    }

}