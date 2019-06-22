package com.inforhomex.calculador;

public class ContenedorCaja{

    private Caja caja;

    public ContenedorCaja(){}

    public void setCaja(Caja caja){
        this.caja = caja;
    }

    public void abrir(){
        this.caja.abrir();
    }

    public void cerrar(){
        this.caja.cerrar();
    }
    
}