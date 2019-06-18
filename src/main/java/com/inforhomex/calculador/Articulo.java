package com.inforhomex.calculador;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("articuloBean")
public class Articulo{

    @Value("Libro: Caído del cielo y levantado del suelo.")
    private String nombre;

    @Value("150.0")
    private double precio;

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    @Override
    public String toString(){
        return "Articulo{nombre = "+this.nombre+", precio= "+this.precio+"}";
    }
}