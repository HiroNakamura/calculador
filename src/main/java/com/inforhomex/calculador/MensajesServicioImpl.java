package com.inforhomex.calculador;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service("mensajesServicio")
public class MensajesServicioImpl implements MensajesServicio{
    
    @Autowired
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