package com.inforhomex.calculador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.inforhomex.calculador.entity.Nota;
import com.inforhomex.calculador.model.MNota;
import com.inforhomex.calculador.converter.Convertidor;
import com.inforhomex.calculador.repository.NotaRepository;

@Service("notaService")
public class NotaServiceImpl implements INotaService{

    @Autowired
    private NotaRepository notaRepository;
    
    @Autowired
    private Convertidor convertidor;

    @Override 
    @Transactional(readOnly = true)
    public List<MNota> findNotasAll(){
        List<Nota> notas = notaRepository.findAll();
        return convertidor.getListaMNotas(notas);
    }

    @Override 
    @Transactional(readOnly = true)
    public MNota findNotaById(Long id){
        return convertidor.getNota(notaRepository.findById(id).orElse(null));
    }
    
    @Override
    @Transactional
    public MNota crearNota(Nota nota){
        MNota mnota = New MNota(notaRepository.save(nota));
        return mnota;
    }
    
    
}
