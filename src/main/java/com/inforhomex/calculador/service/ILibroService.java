package com.inforhomex.calculador.service;

import java.util.List;
import com.inforhomex.calculador.model.MLibro;

public interface ILibroService{
    public abstract List<MLibro> getLibrosAll();
    public abstract MLibro findLibroById(Long id);
}