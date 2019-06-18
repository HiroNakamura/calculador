package com.inforhomex.calculador;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("expresionesServidorBean") 
public class ExpresionesServidor{
    @Value("#{expresionesBean}")
    private Expresiones expresionesBean;

    @Override
    public String toString(){
        return "ExpresionesServidor{expresionesBean = "+this.expresionesBean+"}";
    }
}