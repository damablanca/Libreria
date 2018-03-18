package es.urjc.libreria.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Libro {
	
	@Id
	private Long IdLibro;

	private String autor;
	private String titulo;
	private int anno;
	private int numeroDePaginas;
	private String ISBN;
	private double precio;
	
	@ManyToOne
	@JoinColumn(name="nombre")
	private Editorial editorial;
	
	@ManyToOne
	@JoinColumn(name="IdCategoria")
	private Categoria categoria;
	
	public Libro() {
		
	}
	
	public Libro(String autor, String titulo,Editorial editorial, int anno, int numeroDePaginas, String ISBN, double precio, Categoria categoria) {
		super();
		this.autor = autor;
		this.titulo = titulo;
		this.editorial = editorial;
		this.anno = anno;
		this.numeroDePaginas = numeroDePaginas;
		this.ISBN = ISBN;
		this.precio = precio;
		this.categoria = categoria;
	}
	
	
	public Long getIdLibro() {
		return IdLibro;
	}

	public void setIdLibro(Long idLibro) {
		IdLibro = idLibro;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}
	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
