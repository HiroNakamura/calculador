package com.inforhomex.calculador;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service("mensajesServicioImpl")
public class MensajesServicioImpl implements MensajesServicio{
    
    @Autowired
    @Qualifier("mensajesRepository")
    private MensajesRepository mensajesRepository;

    @Override 
    public List<Mensajes> getTodo(){
        List<Mensajes> mensajes = mensajesRepository.findAll();
        if(mensajes.size() > 0){
            return mensajes;
        }else{
            return null;
        }
    }

    @Override 
    public Mensajes getMensaje(String idioma){
        List<Mensajes> mensajes = mensajesRepository.findAll();
        Mensajes mensaje = mensajes.stream().filter(m -> m.idioma.equals(idioma)).collect(Collectors.toList()).get(0);
        return mensaje;
    }

    @Override 
    public void crearMensaje(String idioma, String mensaje){
        Mensajes mensajes = new Mensajes();
        mensajes.idioma = idioma;
        mensajes.mensaje = mensaje;
        this.mensajesRepository.save(mensajes);
        System.out.println("Mensaje creado {idioma: "+idioma+", mensaje: "+mensaje+"}");
    }
}