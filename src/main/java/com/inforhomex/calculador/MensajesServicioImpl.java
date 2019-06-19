package com.inforhomex.calculador;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.List;

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
}