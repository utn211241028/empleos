package org.atziri.lopez.soriano.db;

import java.util.List;
import java.util.Optional;

import org.atziri.lopez.soriano.model.Categoria;
import org.atziri.lopez.soriano.service.IntCategorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CategoriasServiceJpa implements IntCategorias {
	
	@Autowired
	private CategoriasRepository repoCategorias;

	@Override
	public List<Categoria> obtenerTodas() {
		// TODO Auto-generated method stub
		return repoCategorias.findAll();
	}

	@Override
	public void agregar(Categoria categoria) {
		// TODO Auto-generated method stub
		repoCategorias.save(categoria);
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		Optional<Categoria> optional = repoCategorias.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		repoCategorias.deleteById(idCategoria);
	}

	@Override
	public int totalCategorias() {
		// TODO Auto-generated method stub
		return (int) repoCategorias.count();
	}

	@Override
	public void modificar(Integer posicion, Categoria categoria) {
		// TODO Auto-generated method stub

	}

	@Override
	public int buscarPosicion(Categoria categoria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoCategorias.findAll(page);
	}

}