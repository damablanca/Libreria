package es.urjc.libreria.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.urjc.libreria.domain.Editorial;
import es.urjc.libreria.domain.Libro;
import es.urjc.libreria.domain.RepositorioCategorias;
import es.urjc.libreria.domain.RepositorioEditorial;
import es.urjc.libreria.domain.RepositorioLibro;

@Controller
public class LibreriaController {
// TODO Auto-generated method stub
	@Autowired 
	private RepositorioLibro repositorioLibro;
	
	@Autowired
	private RepositorioEditorial repositorioEditorial;
	
	@Autowired
	private RepositorioCategorias repositorioCategorias;
	
	//Mostrar Libros
	@RequestMapping(value="/mostrar", method=RequestMethod.GET)
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
	public String mosdificarLibro(@PathVariable("id") Long IdLibro, Model model) {
		model.addAttribute("libros", repositorioLibro.findById(IdLibro));
		model.addAttribute("categorias", repositorioCategorias.findAll());
		return "editarLibros";
	}
		
	//Modificar Editorial
	@RequestMapping(value="/modificarEditorial/{id}")
	public String modificarEditorial(@PathVariable("id") Long IdEditorial, Model model) {
		model.addAttribute("editoriales", repositorioEditorial.findById(IdEditorial));
		return "editarEditoriales";
	}
}
