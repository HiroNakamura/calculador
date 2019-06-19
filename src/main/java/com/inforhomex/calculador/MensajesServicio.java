package com.inforhomex.calculador;

import org.springframework.stereotype.Service;
import java.util.List;

@Service("mensajesServicio")
public interface MensajesServicio{
    public abstract List<Mensajes> getTodo();
    public abstract Mensajes getMensaje(String idioma);
}