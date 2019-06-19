package com.inforhomex.calculador;

import org.springframework.data.annotation.Id;

public class Mensajes{

    @Id
    public String id;

    public String idioma;
    public String mensaje;

    public Mensajes(){}

    public Mensajes(String idioma, String mensaje){
        this.idioma = idioma;
        this.mensaje = mensaje;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Mensajes[id=%s, idioma='%s', mensaje='%s']",
                id, idioma, mensaje);
    }

}