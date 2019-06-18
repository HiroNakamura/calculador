package com.inforhomex.calculador;

public class IMC implements ICalculo{
    @Override 
    public double calculo(double peso, double talla){
        return peso/(talla*talla);
    }
}