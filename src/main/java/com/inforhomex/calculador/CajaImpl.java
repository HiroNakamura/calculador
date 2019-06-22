package com.inforhomex.calculador;

public class CajaImpl implements Caja{
    @Override
    public void abrir(){
        System.out.println("Abriendo caja...");
    }

    @Override
    public void cerrar(){
        System.out.println("Cerrando caja...");
    }
}