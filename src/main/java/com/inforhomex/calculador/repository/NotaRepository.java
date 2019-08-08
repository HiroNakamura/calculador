package com.inforhomex.calculador.repository;

import com.inforhomex.calculador.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("notaRepository")
public interface NotaRepository extends JpaRepository<Nota,Long>{

}