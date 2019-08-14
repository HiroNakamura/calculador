package com.inforhomex.calculador.service;

import java.util.List;
import com.inforhomex.calculador.model.MLibro;

public interface ILibroService{
    public abstract List<MLibro> getLibrosAll();
    public abstract MLibro findLibroById(Long id);
    public abstract void createLibro(String titulo,String isbn,Long autor_id);
    public abstract void deleteLibro(Long id);
}