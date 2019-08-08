package com.inforhomex.calculador.converter;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import com.inforhomex.calculador.entity.Nota;
import com.inforhomex.calculador.model.MNota;

@Component("convertidor")
public class Convertidor{

    public List<MNota> getListaMNotas(List<Nota> notas){
        List<MNota> mnotas = new ArrayList<>();
        notas.forEach(nota ->{
            mnotas.add(new MNota(nota));
        });
        return mnotas;
    }

    public MNota getNota(Nota nota){
        return new MNota(nota);
    }

}