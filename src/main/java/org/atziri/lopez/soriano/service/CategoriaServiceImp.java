package org.atziri.lopez.soriano.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.atziri.lopez.soriano.db.CategoriasRepository;
import org.atziri.lopez.soriano.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service 
public class CategoriaServiceImp implements IntCategorias {
	
	@Autowired
	private CategoriasRepository repoCategorias;
	
	//Agregar atributo
	private List<Categoria> lista = null;
	/*-------------------------------------------*/
	//Método Constructor
	public CategoriaServiceImp() {
		lista = new LinkedList<Categoria>();
		//Una instancia
		Categoria c1 = new Categoria();
		c1.setId(1);
		c1.setNombre("Tics");
		c1.setDescripcion("Relación con Informática, Telemática, IoT");
		
		Categoria c2 = new Categoria();
		c2.setId(2);
		c2.setNombre("Educación");
		c2.setDescripcion("Relación con Educación pública y privada");
		
		Categoria c3 = new Categoria();
		c3.setId(3);
		c3.setNombre("Ingenieros");
		c3.setDescripcion("Relación con todas las ramas de la ingeniería");
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
	}
	/*-------------------------------------------*/
	
	@Override
	public List<Categoria> obtenerTodas() {
		return repoCategorias.findAll();
	}

	@Override
	public void agregar(Categoria categoria) {
		repoCategorias.save(categoria);
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = repoCategorias.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		repoCategorias.deleteById(idCategoria);
	}

	@Override
	public int totalCategorias() {
		return (int) repoCategorias.count();
	}

	@Override
	public void modificar(Integer posicion, Categoria categoria) {
		lista.set(posicion, categoria);
		
	}

	@Override
	public int buscarPosicion(Categoria categoria) {
		int index = 0; Categoria aux = null;
		int posicion = -1;
		while(index < lista.size()) {
			aux = lista.get(index);
			if(aux.getId()==categoria.getId()) {
				posicion= index;
				break;
		} index++;
		
	} return posicion;
}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoCategorias.findAll(page);
	}
}