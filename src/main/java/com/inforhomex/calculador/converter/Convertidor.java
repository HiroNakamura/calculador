package com.inforhomex.calculador.converter;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import com.inforhomex.calculador.entity.Autor;
import com.inforhomex.calculador.entity.Nota;
import com.inforhomex.calculador.entity.Libro;
import com.inforhomex.calculador.entity.Empleado;
import com.inforhomex.calculador.model.MAutor;
import com.inforhomex.calculador.model.MNota;
import com.inforhomex.calculador.model.MLibro;
import com.inforhomex.calculador.model.MEmpleado;


@Component("convertidor")
public class Convertidor{

    public List<MEmpleado> getListaMEmpleado(List<Empleado> empleados){
        List<MEmpleado> mempleados = new ArrayList<>();
        empleados.forEach(empleado ->{
            mempleados.add(new MEmpleado(empleado));
        });
        return mempleados;
    }

    public MEmpleado getEmpleado(Empleado empleado){
        return new MEmpleado(empleado);
    }

    public List<MLibro> getListaMLibro(List<Libro> libros){
        List<MLibro> mlibros = new ArrayList<>();
        libros.forEach(libro ->{
            mlibros.add(new MLibro(libro));
        });
        return mlibros;
    }

    public MLibro getLibro(Libro libro){
        return new MLibro(libro);
    }

    public MAutor getAutor(Autor autor){
        return new MAutor(autor);
    }

    public List<MAutor> getListaMAutor(List<Autor> autores){
        List<MAutor> mautores = new ArrayList<>();
        autores.forEach(autor ->{
            mautores.add(new MAutor(autor));
        });
        return mautores;
    }

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