package com.inforhomex.calculador.repository;

import com.inforhomex.calculador.entity.Nodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("nodoRepository")
public interface NodoRepository extends JpaRepository<Nodo,Long>{

}