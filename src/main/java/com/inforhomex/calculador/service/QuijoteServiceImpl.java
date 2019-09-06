package com.inforhomex.calculador.service;

import com.inforhomex.calculador.model.QuijoteFrases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("quijoteServiceImpl") 
public class QuijoteServiceImpl implements QuijoteService{

	@Autowired
	public QuijoteFrases quijoteFrases;
	
	public QuijoteServiceImpl(){}


	@Override
	public String getFrase(){
		return quijoteFrases.getFrases();
	}
}