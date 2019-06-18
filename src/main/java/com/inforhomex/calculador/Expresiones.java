package com.inforhomex.calculador;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("expresionesBean") 
public class Expresiones{
    
    @Value("#{34>55}")
    private boolean falso;

    @Value("#{40>11}")
    private boolean verdadero;

    @Value("#{21+9}")
    private int suma;

    @Value("#{56-43}")
    private int resta;

    @Value("#{'Fernando'+' '+'Carraro Aguirre'}")
    private String concatenar;

    @Override
    public String toString(){
        return "Expresiones{falso = "+this.falso+", verdadero = "+this.verdadero+", suma = "+this.suma+", resta = "+this.resta+", concatenar = "+this.concatenar+"}";
    }

}