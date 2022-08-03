package org.atziri.lopez.soriano.service;

import java.util.List;
import java.util.Optional;

import org.atziri.lopez.soriano.db.UsuariosRepository;
import org.atziri.lopez.soriano.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UserDetailsService {
	
	@Autowired
	private UsuariosRepository repoUsuarios;

	public List<Usuario> obtenerTodas() {
		// TODO Auto-generated method stub
		return repoUsuarios.findAll();
	}

	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		repoUsuarios.save(usuario);
	}

	public void eliminar(Integer idUsuario) {
		// TODO Auto-generated method stub
		repoUsuarios.deleteById(idUsuario);
	}

	public Usuario buscarPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		Optional<Usuario> optional = repoUsuarios.findById(idUsuario);
		if ( optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public long numeroUsuarios() {
		// TODO Auto-generated method stub
		return repoUsuarios.count();
	}

	public Page<Usuario> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoUsuarios.findAll(page);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
