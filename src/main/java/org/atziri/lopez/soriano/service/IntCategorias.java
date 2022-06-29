package org.atziri.lopez.soriano.service;

import java.util.List;

import org.atziri.lopez.soriano.model.Categoria;

public interface IntCategorias {
	/*DECLARACIÓN DE LA LOGICA DEL NEGOCIO A IMPLEMENTAR CON 
	 * NUESTRA CLASE MODELO CATEGORIAS */
	 
	//DECLARACIÓN DE MÉTODOS ABSTRACTOS
	public List<Categoria> obtenerTodas();
	public void agregar (Categoria categoria);
	public Categoria buscarPorId (Integer idCategoria);
	public void eliminar (Integer idCategoria);
	public int totalCategorias();
	public void modificar(Integer posicion, Categoria categoria);
	public int buscarPosicion(Categoria categoria);
}
