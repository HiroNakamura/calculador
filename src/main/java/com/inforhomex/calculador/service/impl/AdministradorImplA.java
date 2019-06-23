package com.inforhomex.calculador.service.impl;

import com.inforhomex.calculador.service.Administrador;
import java.util.Date;

public class AdministradorImplA implements Administrador {
    @Override
    public String getFecha(){
        String resultado = "";
        Date date = new Date();
        resultado += "Fecha de hoy es \n"+date.toString();
        resultado += "\nDia "+getDia(date.getDay());
        resultado += "\nHora "+date.getHours();
        return resultado;
    }

    static String getDia(int n){
        String dia = "";
        switch(n) {
            case 1: dia = "Lunes"; break;
            case 2: dia = "Martes"; break;
            case 3: dia = "Miercoles"; break;
            case 4: dia = "Jueves"; break;
            case 5: dia = "Viernes"; break;
            case 6: dia = "Sabado"; break;
            case 7: dia = "Domingo"; break;
        }
        return dia;
    }
}