package com.inforhomex.calculador;

import org.springframework.stereotype.Component;

@Component("apartadoBean")
public class Apartado{
    public boolean isDisponible(){
        return true;
    }
}