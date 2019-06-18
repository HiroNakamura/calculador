package com.inforhomex.calculador;

public class Jugador implements java.util.Comparator<Jugador> , java.lang.Comparable<Jugador>{

    private String nombre;
    private int edad;
    private IEquipo equipo;

    public Jugador(){}

    public Jugador(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public void setEquipo(IEquipo equipo){
        this.equipo = equipo; 
    }

    public void mostrar(){
        this.equipo.mostrar();
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    @Override
    public String toString(){
        return "Jugador{nombre = "+this.nombre+", edad = "+this.edad+"}"; 
    }

    @Override
    public int compare(Jugador jugadorA, Jugador jugadorB) {
        return jugadorA.getEdad() - jugadorB.getEdad();
    }

    @Override
    public int compareTo(Jugador jugador){
        return this.nombre.compareTo(jugador.getNombre());
    }


}