package org.atziri.lopez.soriano.controller;

import java.beans.PropertyEditorSupport;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.atziri.lopez.soriano.model.Categoria;
import org.atziri.lopez.soriano.model.Vacante;
import org.atziri.lopez.soriano.service.IntCategorias;
import org.atziri.lopez.soriano.service.IntVacantes;
import org.atziri.lopez.soriano.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/vacante")
public class VacantesController {
	
	@Autowired
	private IntVacantes vacantesService;
	
	@Autowired 
	private IntCategorias categoriasService;
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("categorias", categoriasService.obtenerTodas());
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Vacante> lista = vacantesService.obtenerTodas();
		System.out.println(lista);
		model.addAttribute("vacantes", lista);
		return "vacantes/listaVacantes";
	}
	
	@GetMapping("/detalle")
	public String detalles(@RequestParam("id") int idVacante, Model model) {
		Vacante vacante = vacantesService.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		//System.out.println(vacante);
		return "vacantes/detalle";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(
			@RequestParam("id") int idVacante) {
		vacantesService.eliminar(idVacante);
		return "redirect:/vacante/index";	
	}
	
	@GetMapping("/nueva")
	public String nuevaVacante(Vacante vacante) {
		return "vacantes/formVacante";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Vacante vacante, BindingResult result, @RequestParam("archivoImagen") MultipartFile multiPart) {
		System.out.println(vacante);
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}return "vacantes/formVacante";
		}
		if(!multiPart.isEmpty()) {
			//String ruta = "empleos/img-vacantes/"; // Linux/MAC
			String ruta = "///c:/empleos/img-vacantes"; //Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if(nombreImagen != null) { // La imagen si se subio
				// Procesamos la variable nombreImagen
				vacante.setImagen(nombreImagen);
			}
		}
		int index = vacantesService.obtenerTodas().size()-1;
		Vacante aux = vacantesService.obtenerTodas().get(index);
		vacante.setId(aux.getId() + 1);
		vacante.setCategoria(categoriasService.buscarPorId(vacante.getCategoria().getId()));
		vacantesService.guardar(vacante);
		return "redirect:/vacante/index";
	}
	
	@InitBinder
	protected void  initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException{
				setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			}
			@Override
			public String getAsText() throws IllegalArgumentException{
				return DateTimeFormatter.ofPattern("dd-MM-yyyy").format((LocalDate) getValue());
			}
		});
	}
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("id") int idVacante, Model model) {
		Vacante vacante = vacantesService.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		return "vacantes/formVacante";
	}
}
