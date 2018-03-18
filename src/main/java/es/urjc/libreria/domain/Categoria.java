package es.urjc.libreria.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	@Id
	
	private Long IdCategoria;
	private String tipo;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="categoria")
	private List<Libro> libro;
	
	public Categoria() {
		
	}
	
	public Categoria(String tipo) {
		super();
		this.tipo = tipo;
	}

	public List<Libro> getLibro() {
		return libro;
	}

	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}

	public Long getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		IdCategoria = idCategoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
