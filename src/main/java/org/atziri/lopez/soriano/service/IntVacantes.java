package org.atziri.lopez.soriano.service;

import java.util.List;

import org.atziri.lopez.soriano.model.Vacante;

public interface IntVacantes {
	
	public List<Vacante> obtenerTodas();
	public void guardar(Vacante vacante);
	public void eliminar(Integer idVacante);
	public Vacante buscarPorId(Integer idVacante);
	public long numeroVacantes();

}
