package com.inforhomex.calculador.repository;

import com.inforhomex.calculador.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository("autorRepository")
public interface AutorRepository extends JpaRepository<Autor,Long>{
    @Query(value="SELECT * FROM public.autores",nativeQuery=true)
    public List<Autor> getAllAutores();

    @Query(value="SELECT * FROM public.autores AS autor WHERE autor.id = ?1",nativeQuery=true)
    public Autor findAutorById(Long id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO public.autores(nombre,apellidos) VALUES (?1,?2)",nativeQuery=true)
    public Autor createAutor(@Param("nombre") String nombre,@Param("apellidos") String apellidos);
}