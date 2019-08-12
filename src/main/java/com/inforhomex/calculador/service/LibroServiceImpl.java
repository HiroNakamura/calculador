package com.inforhomex.calculador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.inforhomex.calculador.model.MLibro;
import com.inforhomex.calculador.converter.Convertidor;
import com.inforhomex.calculador.entity.Libro;
import com.inforhomex.calculador.repository.LibroRepository;
import java.util.List;

@Service("libroService")
public class LibroServiceImpl implements ILibroService{
    @Autowired
    private LibroRepository libroRepository;
    
    @Autowired
    private Convertidor convertidor;

    @Override 
    @Transactional(readOnly = true)
    public List<MLibro> getLibrosAll(){
        List<Libro> libros = libroRepository.getAllLibros();
        return convertidor.getListaMLibro(libros);
    }

    @Override 
    @Transactional(readOnly = true)
    public MLibro findLibroById(Long id){
        Libro libro = libroRepository.findLibroById(id);
        return convertidor.getLibro(libro);
    }
}