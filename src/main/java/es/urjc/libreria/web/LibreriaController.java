package es.urjc.libreria.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.urjc.libreria.domain.Categoria;
import es.urjc.libreria.domain.CategoriaRepositorio;
import es.urjc.libreria.domain.Editorial;
import es.urjc.libreria.domain.EditorialRepositorio;
import es.urjc.libreria.domain.Libro;
import es.urjc.libreria.domain.LibroRepositorio;

@Controller
public class LibreriaController {
// TODO Auto-generated method stub
	@Autowired 
	private LibroRepositorio repositorioLibro;
	
	@Autowired
	private EditorialRepositorio repositorioEditorial;

	@Autowired
	private CategoriaRepositorio repositorioCategorias;
	
	
	@PostConstruct
	public void init() {
		
		repositorioCategorias.save(new Categoria("Fantasia"));
		repositorioCategorias.save(new Categoria("Ciencia"));
		
		repositorioEditorial.save(new Editorial("Anaya","923478651","anaya.edit@anaya.com", "Industria 26, Madrid, 28040", "ID26"));
		repositorioEditorial.save(new Editorial("Panamerica","983426790","grupo.oceano@grupoceano.es", "Gran Via 56, Madrid, 28040", "ID98"));
		
		repositorioLibro.save(new Libro("Fernando Trujillo","La Guerra de los Cielos",repositorioEditorial.findByNombre("Panamerica"),2016,300,"AJ234",15.50,repositorioCategorias.findByTipo("Fantasia")));
		repositorioLibro.save(new Libro("Pepito Grillo","Viajes en el Tiempo",repositorioEditorial.findByNombre("Anaya"),2014,400,"BP566",20.50,repositorioCategorias.findByTipo("Ciencia")));	
	}
	
	//Mostrar Libros
	@RequestMapping(value="/mostrar")
	public String mostrarLibro(Model model) {
		model.addAttribute("libros", repositorioLibro.findAll()); 
		return "consultarLibros";
	}
		
	//Mostrar Editorial
	@RequestMapping(value="/mostrar", method=RequestMethod.GET)
	public String mostrarEditorial(Model model) {
		model.addAttribute("editoriales", repositorioEditorial.findAll()); 
		return "consultarEditoriales";
	}
			
	//Agregar Libro
	@RequestMapping(value="/agregarLibro")
	public String agregarLibro(Model model) {
		model.addAttribute("libros", new Libro());
		model.addAttribute("categorias", repositorioCategorias.findAll());
		return "anadirLibros";
	}
	
	//Agregar Editorial
	@RequestMapping(value="/agregarEditorial")
	public String agregarEditorial(Model model) {
		model.addAttribute("editoriales", new Editorial());
		return "anadirEditorial";
	}
	
	//guardar libros
	@RequestMapping(value="/guardarLibros", method=RequestMethod.POST)
	public String guardarLibros(Libro libro) {
		repositorioLibro.save(libro);
		return "redirect:consultarLibros";
	}
		
	//guardar editoriales
	@RequestMapping(value="/guardarEditoriales", method=RequestMethod.POST)
	public String guardarEditoriales(Editorial editorial) {
		repositorioEditorial.save(editorial);
		return "redirect:consultarEditorial";
	}
	
	//Modificar Libro
	@RequestMapping(value="/modificarLibro/{id}")
	public String modificarLibro(@PathVariable("id") long idLibro, Model model) {
		model.addAttribute("libros", repositorioLibro.getOne(idLibro));
		model.addAttribute("categorias", repositorioCategorias.findAll());
		return "editarLibros";
	}
		
	//Modificar Editorial
	@RequestMapping(value="/modificarEditorial/{id}")
	public String modificarEditorial(@PathVariable("id") long idEditorial, Model model) {
		model.addAttribute("editoriales", repositorioEditorial.getOne(idEditorial));
		return "editarEditoriales";
	}
	
}