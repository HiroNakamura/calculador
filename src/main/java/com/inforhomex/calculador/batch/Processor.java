package com.inforhomex.calculador.batch;

import com.inforhomex.springforlotes.entity.Empleado;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<Empleado, Empleado>{

    @Override
    public Empleado process(Empleado empleado) throws Exception {
        String nombre = empleado.getNombre().toUpperCase();
        String apellido = empleado.getApellido().toUpperCase();
        System.out.println(String.format("nombre y apellidos de [%s] to [%s]", empleado.getNombre(),nombre));
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        return empleado;
    }
    
}
