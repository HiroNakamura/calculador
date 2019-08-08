package com.inforhomex.calculador.controller;

import com.inforhomex.calculador.model.MNota;
import com.inforhomex.calculador.service.NotaServiceImpl;
import com.inforhomex.calculador.converter.Convertidor;
import com.inforhomex.calculador.entity.Nota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/curso")
public class NotaRestController{
    
    @Autowired
    private NotaServiceImpl notaServiceImpl;

    @Autowired
    private Convertidor convertidor;

    //http://localhost:8090/curso/notas
    @GetMapping("/notas")
    public List<MNota> notas(){
        List<Nota> notas = notaServiceImpl.findNotasAll();
        return convertidor.getListaMNotas(notas);
    }
    
    //http://localhost:8090/curso/notas/1
    @GetMapping("/notas/{id}")
    public MNota nota(@PathVariable Long id){
        Nota nota = notaServiceImpl.findNotaById(id);
        return convertidor.getNota(nota);
    }

    


}