package com.inforhomex.calculador.config;


import com.inforhomex.calculador.model.QuijoteFrases;
import com.inforhomex.calculador.service.QuijoteService;
import com.inforhomex.calculador.service.QuijoteServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class QuijoteConfiguration{
	
	@Bean(name="quijoteServiceBean")
	public QuijoteService quijoteService(){
		return new QuijoteServiceImpl();
	}

	@Bean
	public QuijoteFrases quijoteFrases(){
		return new QuijoteFrases();
	}
}