package com.inforhomex.calculador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MensajeroServicio{
    @Autowired
    private Mensajero mensajero;

    @Override
    public String toString(){
        return "MensajeroServicio["+this.mensajero+"]";
    }
}