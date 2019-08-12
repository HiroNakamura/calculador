package com.inforhomex.calculador.repository;

import com.inforhomex.calculador.entity.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository("libroRepository")
public interface LibroRepository extends JpaRepository<Libro,Long>{
    @Query(value="SELECT autor.id, autor.nombre,autor.apellido, libro.titulo FROM public.libros AS libro INNER JOIN public.autores AS autor ON autor.id=libro.autor_id order by autor.nombre",nativeQuery=true)
    public List<Libro> getAllLibros();
}