package com.inforhomex.calculador.service.impl;

import com.inforhomex.calculador.service.Administrador;
import java.time.LocalDateTime;

public class AdministradorImplB implements Administrador{
    @Override 
    public String getFecha(){
        return "La fecha es "+LocalDateTime.now().toString();
    }
}