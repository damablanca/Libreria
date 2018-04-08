package es.urjc.libreria.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialRepositorio extends JpaRepository<Editorial, Long> {
	Editorial findByNombre(String nombre);
	List<Editorial> findByIdentificacion(String identificacion);
	Editorial findByIdEditorial(long idEditorial);
}
