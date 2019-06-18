package com.inforhomex.calculador;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("servidorBean") 
public class Servidor{

    @Value("#{articuloBean}")
    private Articulo articuloBean;

    @Value("#{articuloBean.nombre}")
    private String nombre;

    @Value("#{apartadoBean.isDisponible()}")
    private boolean disponibilidad;

    public Articulo getArticuloBean(){
        return articuloBean;
    }

    public void setArticuloBean(Articulo articuloBean){
        this.articuloBean = articuloBean;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public boolean getDisponibilidad(){
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString(){
        String disponible = this.disponibilidad? "Si, esta disponible" : "No, no esta disponible";
        return "Servidor{articuloBean = "+this.articuloBean+", nombre = "+this.nombre+",Esta disponible? "+disponible+"}";
    }

}