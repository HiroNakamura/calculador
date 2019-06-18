package com.inforhomex.calculador;

public class Punto extends Object{
    private double x;
    private double y;

    public Punto(){}

    public Punto(double x, double y){
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

    @Override
    public String toString(){
        String resultado = "";
        if(this.getX() == 0 && this.getY() == 0){
            resultado = "Punto{}";
        }else{
            resultado =  "Punto{x = "+this.x+", y = "+this.y+"}";;
        }
        return resultado;
    }

    public void imprimir(){
        System.out.println(this.toString());
    }
}