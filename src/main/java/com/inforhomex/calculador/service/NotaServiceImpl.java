package com.inforhomex.calculador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.inforhomex.calculador.entity.Nota;
import com.inforhomex.calculador.repository.NotaRepository;

@Service("notaService")
public class NotaServiceImpl implements INotaService{

    @Autowired
    private NotaRepository notaRepository;

    @Override 
    @Transactional(readOnly = true)
    public List<Nota> findNotasAll(){
        return notaRepository.findAll();
    }

    @Override 
    @Transactional(readOnly = true)
    public Nota findNotaById(Long id){
        return notaRepository.findById(id).orElse(null);
    }
}