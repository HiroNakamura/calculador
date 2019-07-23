package com.inforhomex.calculador.processor;

import com.inforhomex.calculador.tutorial.model.Persona;
import org.springframework.batch.item.ItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonaItemProcessor implements ItemProcessor<Persona,Persona>{

	private static final Logger LOG = LoggerFactory.getLogger(PersonaItemProcessor.class);


	@Override
	public Persona process(Persona item) throws Exception{
		String nombre= item.getNombre().toUpperCase();
		String apellido = item.getApellido().toUpperCase();
		String telefono = item.getTelefono();

		Persona persona = new Persona(nombre,apellido,telefono);
		LOG.info("Convirtiendo original ["+item+"] a  nuevo [ "+persona+"]");

		return persona;
	}
}
