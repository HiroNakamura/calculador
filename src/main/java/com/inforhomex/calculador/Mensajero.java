package com.inforhomex.calculador;

import org.springframework.stereotype.Component;

@Component
public class Mensajero{
    @Override
    public String toString(){
        return "El Mensajero del sultán de Ribola ha llegado.";
    }
}