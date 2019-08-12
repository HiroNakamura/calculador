package com.inforhomex.calculador.repository;

import com.inforhomex.calculador.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository("autorRepository")
public interface AutorRepository extends JpaRepository<Autor,Long>{
    @Query(value="SELECT * FROM public.autores",nativeQuery=true)
    public List<Autor> getAllAutores();

    @Query(value="SELECT * FROM public.autores AS autor WHERE autor.id = ?1",nativeQuery=true)
    public Autor findAutorById(Long id);
}