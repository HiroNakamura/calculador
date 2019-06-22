package com.inforhomex.calculador;

import java.time.LocalDateTime;

public class AdministradorImplB implements Administrador{
    @Override 
    public String getFecha(){
        return "La fecha es "+LocalDateTime.now().toString();
    }
}