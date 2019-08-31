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
    
    @Query(value="SELECT autor.id, autor.nombre, autor.apellido FROM public.autores as autor",nativeQuery=true)
    public List<Autor> getAllAutores();

    @Query(value="SELECT * FROM public.autores AS autor WHERE autor.id = ?1",nativeQuery=true)
    public Autor findAutorById(Long id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO public.autores(nombre,apellido) VALUES (:nombre,:apellido)",nativeQuery=true)
    public void createAutor(@Param("nombre") String nombre,@Param("apellido") String apellidos);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM public.libros WHERE autor_id = :id ; DELETE FROM public.autores WHERE id = :id ",nativeQuery=true)
    public void deleteAutor(@Param("id") Long id);

    @Modifying
    @Transactional 
    @Query(value="UPDATE public.autores SET nombre = :nombre, apellido = :apellido  WHERE id = :id",nativeQuery=true)
    public void updateAutor(@Param("id") Long id,@Param("nombre") String nombre,@Param("apellido") String apellido);

}