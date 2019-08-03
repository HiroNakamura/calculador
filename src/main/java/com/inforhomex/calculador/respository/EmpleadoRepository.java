package com.inforhomex.calculador.repository;

import com.inforhomex.calculador.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
    
}
