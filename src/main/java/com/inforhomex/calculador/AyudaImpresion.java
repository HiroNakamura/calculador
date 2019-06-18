package com.inforhomex.calculador;

public class AyudaImpresion{

    private Impresora impresora;

    public void setImpresora(Impresora impresora){
        this.impresora = impresora;
    }

    public void imprimir(){
        this.impresora.imprimir();
    }

}
