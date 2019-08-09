package com.inforhomex.calculador.service;

import com.inforhomex.calculador.model.MNota;
import com.inforhomex.calculador.entity.Nota;
import java.util.List;

public interface INotaService{
    public abstract List<MNota> findNotasAll();
    public abstract MNota findNotaById(Long id);
    public abstract MNota crearNota(Nota nota);
}
