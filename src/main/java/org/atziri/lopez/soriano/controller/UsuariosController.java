package org.atziri.lopez.soriano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/demo-bcrypt")
	public String pruebaBcrypt() {
	String password = "mari123";
	String encriptado = passwordEncoder.encode(password);
	System.out.println("Password encriptado: " + encriptado);
	return "usuarios/demo";
	}
}
