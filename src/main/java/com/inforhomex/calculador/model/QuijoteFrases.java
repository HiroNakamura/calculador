package com.inforhomex.calculador.model;


public final class QuijoteFrases{

	public static final String[] FRASE = {"A menos que sea la muerte, para todo hay remedio.".toUpperCase()
	,"no puede impedirse el viento, pero hay que saber hacer molinos".toUpperCase()
	,"si los perros ladran, Sancho, es señal que cabalgamos".toUpperCase()};
	
	public QuijoteFrases(){}

	
	public String getFrases(){
		return FRASE[(int)Math.random()*2];
	}

}