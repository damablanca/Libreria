package es.urjc.libreria.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
	List<Libro> findByTitulo(String titulo);
	Libro findByIdLibro(long idLibro);
}
