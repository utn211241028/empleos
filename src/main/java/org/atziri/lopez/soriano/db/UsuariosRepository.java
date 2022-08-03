package org.atziri.lopez.soriano.db;

import org.atziri.lopez.soriano.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
