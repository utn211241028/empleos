package com.LeonardoLopez.Org.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeonardoLopez.Org.Model.Categoria;


public interface CategoriasRepository extends JpaRepository <Categoria, Integer> {
	
}
