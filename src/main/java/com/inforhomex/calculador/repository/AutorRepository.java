package com.inforhomex.calculador.repository;

import com.inforhomex.calculador.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("autorRepository")
public interface AutorRepository extends JpaRepository<Autor,Long>{

}