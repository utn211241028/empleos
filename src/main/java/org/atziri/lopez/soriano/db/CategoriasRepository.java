package org.atziri.lopez.soriano.db;

import org.atziri.lopez.soriano.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

//public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {
public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {
	//métodos para persistencia de datos con sql nativo
}
