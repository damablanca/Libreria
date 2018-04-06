package es.urjc.libreria.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RepositorioCategorias extends CrudRepository<Categoria, Long> {
	List<Categoria> buscarNombre(String tipo);
}
