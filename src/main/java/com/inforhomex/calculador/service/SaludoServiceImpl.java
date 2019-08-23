package com.inforhomex.calculador.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("saludoServiceImpl")
@Primary
public class SaludoServiceImpl implements ISaludoService{

    @Override
    public String decirHola(String nombre) {
        if(nombre == null){
            return "Hola, mundo!!";
        }
        return "Hola, "+nombre;
    }
    
}