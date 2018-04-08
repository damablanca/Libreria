package es.urjc.libreria.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
	Categoria findByTipo(String tipo);
}
