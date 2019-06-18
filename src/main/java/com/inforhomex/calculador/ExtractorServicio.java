package com.inforhomex.calculador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExtractorServicio{

	@Autowired
	private Extractor extractor;

	public void extraer(){
		this.extractor.extraer();
	}
}