package com.inforhomex.calculador;

public class Medidor{
    private double x;
    private double y;
    private ICalculo calculo;

    public Medidor(){}

    public Medidor(ICalculo calculo, double x, double y){
        this.calculo= calculo;
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return y;
    }

    public void setY(double y){
        this.y = y;
    }

    public double calculo(){
        return this.calculo.calculo(this.x, this.y);
    }

    public void setCalculo(ICalculo calculo){
        this.calculo = calculo;
    }

    public ICalculo getCalculo(){
        return calculo;
    }
}