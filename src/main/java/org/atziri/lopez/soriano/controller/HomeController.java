package org.atziri.lopez.soriano.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.atziri.lopez.soriano.model.Categoria;
import org.atziri.lopez.soriano.model.Perfil;
import org.atziri.lopez.soriano.model.Usuario;
import org.atziri.lopez.soriano.model.Vacante;
import org.atziri.lopez.soriano.service.IntCategorias;
import org.atziri.lopez.soriano.service.IntUsuarios;
import org.atziri.lopez.soriano.service.IntVacantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller	
public class HomeController {
	
	@Autowired 
	private IntVacantes serviceVacantes;
	
	@Autowired
	private IntCategorias serviceCategorias;
	
	@Autowired
	private IntUsuarios serviceUsuarios;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping ("/")
	public String mostrarHome(Model model, Pageable page) {
		List<Vacante> lista = serviceVacantes.obtenerTodas();
		List<Categoria> categorias = serviceCategorias.obtenerTodas();
		model.addAttribute("vacantes",lista);
		model.addAttribute("categorias", categorias);
		return "home";
	}
	
	@GetMapping("/signup")
	public String registrarse(Usuario usuario) {
		return "formRegistro";
	}
	
	/*
	  Método que guarda en la base de datos el usuario registrado
*/
	@PostMapping("/signup")
	public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {
		// Recuperamos el password en texto plano
		String pwdPlano = usuario.getPassword();
		// Encriptamos el pwd BCryptPasswordEncoder
		String pwdEncriptado = passwordEncoder.encode(pwdPlano); 
		// Hacemos un set al atributo password (ya viene encriptado)
		usuario.setPassword(pwdEncriptado);	
		usuario.setEstatus(1); // Activado por defecto
		usuario.setFechaRegistro(LocalDate.now()); // Fecha de Registro, la fecha actual del servidor
		
		// Creamos el Perfil que le asignaremos al usuario nuevo
		Perfil perfil = new Perfil();
		perfil.setId(3); // Perfil USUARIO
		usuario.agregar(perfil);
		/**
		 * Guardamos el usuario en la base de datos. El Perfil se guarda automaticamente
		 */
		serviceUsuarios.guardar(usuario);		
		attributes.addFlashAttribute("msg", "Has sido registrado. ¡Ahora puedes ingresar al sistema!");	
		return "redirect:/login";
	}
	
	@GetMapping("/login" )
	public String mostrarLogin() {
			//return "formLogin";
		return "formLogin";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request){
			SecurityContextLogoutHandler logoutHandler =
						new SecurityContextLogoutHandler();
			logoutHandler.logout(request, null, null);
			return "redirect:/formLogin";
	}

	@GetMapping("/bcript/{texto}")
	@ResponseBody
	public String encriptar(@PathVariable("texto") String texto) {
		return texto + "encriptado en Bcrypt : "+ passwordEncoder.encode(texto);
	}



}
