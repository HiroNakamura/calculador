package com.inforhomex.calculador;

public class ImprimePDF implements Impresora{
    @Override
    public void imprimir(){
        System.out.println("Imprimiendo documento .pdf");
    }
}