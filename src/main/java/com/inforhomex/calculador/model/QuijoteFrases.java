package com.inforhomex.calculador.model;


public final class QuijoteFrases{

	public static final String[] FRASE = {"a menos que sea la muerte, para todo hay remedio.".toUpperCase()
	,"da crédito a las obras y no a las palabras".toUpperCase()
	,"hacer bien a villanos es echar agua en el mar".toUpperCase()
	,"no puede impedirse el viento, pero hay que saber hacer molinos".toUpperCase()
	,"si los perros ladran, Sancho, es señal que cabalgamos".toUpperCase()};
	
	public QuijoteFrases(){}

	
	public String getFrases(){
		return FRASE[(int)Math.random()*4];
	}

}