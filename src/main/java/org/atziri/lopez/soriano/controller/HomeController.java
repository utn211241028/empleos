package org.atziri.lopez.soriano.controller;

import java.util.List;

import org.atziri.lopez.soriano.model.Categoria;
import org.atziri.lopez.soriano.model.Vacante;
import org.atziri.lopez.soriano.service.IntCategorias;
import org.atziri.lopez.soriano.service.IntVacantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	
public class HomeController {
	
	@Autowired 
	private IntVacantes serviceVacantes;
	
	@Autowired
	private IntCategorias serviceCategorias;
	
	@GetMapping ("/")
	public String mostrarHome(Model model) {
		List<Vacante> lista = serviceVacantes.obtenerTodas();
		List<Categoria> categorias = serviceCategorias.obtenerTodas();
		model.addAttribute("vacantes",lista);
		model.addAttribute("categorias", categorias);
		return "home";
	}
}
