package com.inforhomex.calculador.service;

import java.util.List;
import com.inforhomex.calculador.model.MAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.inforhomex.calculador.converter.Convertidor;
import com.inforhomex.calculador.entity.Autor;
import com.inforhomex.calculador.repository.AutorRepository;

@Service("autorService")
public class AutorServiceImpl implements IAutorService{

    @Autowired
    private AutorRepository autorRepository;
    
    @Autowired
    private Convertidor convertidor;    

    @Override 
    @Transactional(readOnly = true)
    public List<MAutor> getAutoresAll(){
        List<Autor> autores = autorRepository.getAllAutores();
        return convertidor.getListaMAutor(autores);
    }


    @Override 
    @Transactional(readOnly = true)
    public MAutor findAutorById(Long id){
        Autor autor = autorRepository.findAutorById(id);
        return convertidor.getAutor(autor);
    }

    @Override
    public void createAutor(String nombre,String apellidos){
        autorRepository.createAutor(nombre, apellidos);
    }

    @Override
    public void deleteAutor(Long id){
        autorRepository.deleteAutor(id);
    }

    @Override
    public MAutor updateAutor(Long id, String nombre, String apellido){
        Autor autorEncontrado = autorRepository.findAutorById(id);
        MAutor autor = null;
        if(autorEncontrado != null && autorRepository.existsById(id)){
            autorEncontrado.setNombre(nombre);
            autorEncontrado.setApellido(apellido);
            autorRepository.save(autorEncontrado);
            autor = new MAutor(autorEncontrado);
            return autor;
        }
        return null;
    }

}