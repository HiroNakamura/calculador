package com.inforhomex.calculador.services;

import com.inforhomex.calculador.entity.Pais;
import com.inforhomex.batches.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("paisServiceImpl")
public class PaisServiceImpl implements CrudService<Pais,Integer>{

    @Autowired
    public PaisRepository paisRepository;


    @Override
    public Set<Pais> findAll(){
        List<Pais> listaPaises = paisRepository.findAll();
        Set<Pais> paises = new HashSet<>();
        listaPaises.forEach(pais ->{
            paises.add(pais);
        });
        return paises;
    }

    @Override
    public Pais save(Pais obj){
        return paisRepository.save(obj);
    }

    @Override
    public Pais findById(Integer id){
        return  paisRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Pais obj){
        paisRepository.delete(obj);
    }
    
    @Override
    public void deleteById(Integer id){
        paisRepository.deleteById(id);
    }

}