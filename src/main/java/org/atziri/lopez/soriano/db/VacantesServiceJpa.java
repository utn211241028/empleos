package org.atziri.lopez.soriano.db;

import java.util.List;
import java.util.Optional;

import org.atziri.lopez.soriano.model.Vacante;
import org.atziri.lopez.soriano.service.IntVacantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class VacantesServiceJpa implements IntVacantes {
	
	@Autowired
	private VacantesRepository repoVacantes;

	@Override
	public List<Vacante> obtenerTodas() {
		// TODO Auto-generated method stub
		 return repoVacantes.findAll();
	}
	
	@Override
	public void guardar(Vacante vacante) {
		// TODO Auto-generated method stub
		repoVacantes.save(vacante);
	}

	@Override
	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		repoVacantes.deleteById(idVacante);
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		Optional<Vacante> optional = repoVacantes.findById(idVacante);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public long numeroVacantes() {
		// TODO Auto-generated method stub
		return repoVacantes.count();
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoVacantes.findAll(page);
	}

}
