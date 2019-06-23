package com.inforhomex.calculador;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document(collection = "mensajes")
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

    public String getId(){
        return id;
    }

    public String getIdioma(){
        return idioma;
    }

    public void setIdioma(String idioma){
        this.idioma = idioma;
    }

    public String getMensaje(){
        return mensaje;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Mensajes[id=%s, idioma='%s', mensaje='%s']",
                id, idioma, mensaje);
    }

}