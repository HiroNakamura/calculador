package com.inforhomex.calculador.repository;

import com.inforhomex.calculador.entity.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;


@Repository("libroRepository")
public interface LibroRepository extends JpaRepository<Libro,Long>{
    @Query(value="SELECT * FROM public.libros",nativeQuery=true)
    public List<Libro> getAllLibros();

    @Query(value="SELECT * FROM public.libros AS libro WHERE libro.id = ?1",nativeQuery=true)
    public Libro findLibroById(Long id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO public.libros(titulo,isbn,autor_id) VALUES (:titulo,:isbn,:autor_id)",nativeQuery=true)
    public void createLibro(@Param("titulo") String titulo,@Param("isbn") String isbn,@Param("autor_id") Long autor_id);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM public.libros WHERE id = :id ",nativeQuery=true)
    public void deleteLibro(@Param("id") Long id);

    @Modifying
    @Transactional 
    @Query(value="UPDATE public.libros SET titulo = :titulo, isbn = :isbn, autor_id = :autor_id  WHERE id = :id",nativeQuery=true)
    public Libro updateLibro(@Param("id") Long id,@Param("titulo") String titulo,@Param("isbn") String isn, @Param("autor_id")Long autor_id);


}