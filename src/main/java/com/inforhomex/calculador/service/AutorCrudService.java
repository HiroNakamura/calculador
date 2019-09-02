package com.inforhomex.calculador.service;


import com.inforhomex.calculador.entity.Autor;
import com.inforhomex.calculador.repository.AutorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("autorCrudService")
public class AutorCrudService implements CrudService<Autor, Long>{

	@Autowired
	public AutorRepository autorRepository;

	@Override
	@Transactional(readOnly = true)
	public Set<Autor> findAll(){
		return null;
	}

	@Override
	public Autor findById(Long id){
		return null;
	}

	@Override
	public Autor save(Autor object){
		return null;
	}

	@Override
	public void delete(Autor object){

	}

	@Override
	public void deleteById(Long id){

	}

}