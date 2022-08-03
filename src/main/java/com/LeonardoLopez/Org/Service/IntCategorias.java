package com.LeonardoLopez.Org.Service;


import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.LeonardoLopez.Org.Model.Categoria;
import com.LeonardoLopez.Org.Model.Vacante;

public interface IntCategorias {
	
	public List<Categoria>ObtenerTodas();
	public void agregar (Categoria categoria);
	public Categoria buscarPorId (Integer idCategoria); 
	public void eliminar (Integer idCtargoria);
	public int totaCategorias();
	int ids();
	void modificar(int posicion, Categoria cat);
	public int buscarPosicion(@Valid Categoria categoria);
	public Page<Categoria> buscarTodas(Pageable page);
}
