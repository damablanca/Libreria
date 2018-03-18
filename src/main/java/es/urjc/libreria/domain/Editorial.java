package es.urjc.libreria.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Editorial {
	@Id
	
	private Long IdEditorial;
	
	private String nombre;
	private String telefono;
	private String correo;
	private String direccionPostal;
	private String identificacion;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="editorial")
	private List<Libro> libro;
	
	public Editorial() {
		
	}
	
	public Editorial(String nombre, String telefono,String correo, String direccionPostal, String identificacion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.direccionPostal = direccionPostal;
		this.identificacion = identificacion;
	}

	public List<Libro> getLibro() {
		return libro;
	}

	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}

	public Long getIdEditorial() {
		return IdEditorial;
	}

	public void setIdEditorial(Long idEditorial) {
		IdEditorial = idEditorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	

}
