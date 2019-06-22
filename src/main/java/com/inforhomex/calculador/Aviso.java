package com.inforhomex.calculador;

//import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Aviso{
    
    private int id;
    private String mensaje;

    public int getId(){
        return id;
    }

    @XmlElement
    public void setId(int id){
        this.id = id;
    }

    public String getMensaje(){
        return mensaje;
    }
    @XmlElement
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    @Override
    public String toString(){
        return String.format("{id: %d, aviso: %s}",id,mensaje);
    }

}