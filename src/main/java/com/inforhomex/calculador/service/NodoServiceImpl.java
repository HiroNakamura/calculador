package com.inforhomex.calculador.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.inforhomex.calculador.entity.Nodo;
import com.inforhomex.calculador.repository.NodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("nodoServiceImpl")
public class NodoServiceImpl implements NodoService{

    @Autowired
    public NodoRepository nodoRepository;

    @Override
    @Transactional(readOnly = true)
	public Set<Nodo> findAll() {
        List<Nodo> listaNodo = nodoRepository.findAll();
        Set<Nodo> nodos = new HashSet<>();
        listaNodo.forEach(nodo -> {
            nodos.add(nodo);
        });
		return nodos;
	}

    @Override
    @Transactional(readOnly = true)
	public Nodo findById(Long id) {
		return nodoRepository.findById(id).orElse(null);
	}

    @Override
    @Transactional
	public Nodo save(Nodo object) {
		return nodoRepository.save(object);
	}

    @Override
    @Transactional
	public void delete(Nodo object) {
		nodoRepository.delete(object);
	}

    @Override
    @Transactional
	public void deleteById(Long id) {
        Nodo nodoBorrar = findById(id);
        nodoRepository.deleteById(nodoBorrar.getId());
	}
}