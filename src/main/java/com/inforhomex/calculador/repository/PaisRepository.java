package com.inforhomex.calculador.repository;

import com.inforhomex.calculador.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Integer> {
}