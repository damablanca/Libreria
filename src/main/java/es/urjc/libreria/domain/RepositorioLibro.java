package es.urjc.libreria.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RepositorioLibro extends CrudRepository<Libro, Long> {
	List<Libro> buscarNombreLibro(String titulo);
	List<Libro> buscarIdLibro(long IdLibro);
}
