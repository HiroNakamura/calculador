package com.inforhomex.calculador;

public class Pulsaciones implements ICalculo{
    @Override
    public double calculo(double x, double y){
        int edad = (int) x;
        return (double) (y - (0.73 * edad));
    }
}