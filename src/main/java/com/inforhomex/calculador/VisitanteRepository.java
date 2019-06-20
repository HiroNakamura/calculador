package com.inforhomex.calculador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("visitanteRepository")
public interface VisitanteRepository extends JpaRepository<Visitante,Long>{

}