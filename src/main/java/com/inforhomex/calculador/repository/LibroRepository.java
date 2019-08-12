package com.inforhomex.calculador.repository;

import com.inforhomex.calculador.entity.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository("libroRepository")
public interface LibroRepository extends JpaRepository<Libro,Long>{
    @Query(value="SELECT * FROM public.libros",nativeQuery=true)
    public List<Libro> getAllLibros();

    @Query(value="SELECT * FROM public.libros AS libro WHERE libro.id = ?1",nativeQuery=true)
    public Libro findLibroById(Long id);
}