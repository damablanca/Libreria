package es.urjc.libreria.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RepositorioEditorial extends CrudRepository<Editorial, Long> {
	List<Editorial> buscarNombreEditorial(String nombre);
	List<Editorial> buscarIdentificacion(String identificacion);
	List<Editorial> buscarIdEditorial(Long IdEditorial);
}
