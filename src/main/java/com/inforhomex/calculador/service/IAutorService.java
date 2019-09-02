package com.inforhomex.calculador.service;

import java.util.List;
import com.inforhomex.calculador.model.MAutor;

public interface IAutorService{
    public abstract List<MAutor> getAutoresAll();
    public abstract List<MAutor> getAutoresTodo();
    public abstract MAutor findAutorById(Long id);
    public abstract void createAutor(String nombre,String apellidos);
    public abstract void deleteAutor(Long id);
    public abstract void updateAutor(Long id, String nombre, String apellido);
}
