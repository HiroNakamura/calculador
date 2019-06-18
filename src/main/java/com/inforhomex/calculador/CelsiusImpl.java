package com.inforhomex.calculador;

public class CelsiusImpl implements Celsius{

    @Override
    public void imprimirCelsius(double valor){
        double resultado = (valor - 32) * 0.555;
        System.out.println("Grados Celsius de: "+valor);
        System.out.println("Es: "+resultado);
    }
}