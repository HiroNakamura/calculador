package com.inforhomex.calculador.service;

import com.inforhomex.calculador.entity.Nota;
import java.util.List;

public interface INotaService{
    public abstract List<Nota> findNotasAll();
    public abstract Nota findNotaById(Long id);
}