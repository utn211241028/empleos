package org.atziri.lopez.soriano.db;

import java.util.List;
import java.util.Optional;

import org.atziri.lopez.soriano.model.Usuario;
import org.atziri.lopez.soriano.service.IntUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
@Primary
public class UsuariosServiceJpa implements IntUsuarios {
	
	@Autowired
	private UsuariosRepository repoUsuarios;

	@Override
	public List<Usuario> obtenerTodas() {
		// TODO Auto-generated method stub
		return repoUsuarios.findAll();
	}

	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		repoUsuarios.save(usuario);
	}

	@Override
	public void eliminar(Integer idUsuario) {
		// TODO Auto-generated method stub
		repoUsuarios.deleteById(idUsuario);
	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		Optional<Usuario> optional = repoUsuarios.findById(idUsuario);
		if ( optional.isPresent()) {
			return optional.get();
		}
		return null;

	}

	@Override
	public long numeroUsuarios() {
		// TODO Auto-generated method stub
		return repoUsuarios.count();
	}

	@Override
	public Page<Usuario> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoUsuarios.findAll(page);
	}

}
