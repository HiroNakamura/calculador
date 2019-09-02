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
		List<Autor> listaAutores = autorRepository.findAll();
        Set<Autor> autors = new HashSet<>();
        listaAutores.forEach(autor->{
            autors.add(autor);
        });
        return autors;
	}

	@Override
    @Transactional(readOnly = true)
	public Autor findById(Long id){
		return autorRepository.getOne(id);
	}

	@Override
	@Transactional
	public Autor save(Autor object){
		return autorRepository.save(object);
	}

	@Override
	@Transactional
	public void delete(Autor object){
		autorRepository.delete(object);
	}

	@Override
	@Transactional
	public void deleteById(Long id){
		autorRepository.deleteById(id);
	}

}