package com.joseleonardo.carteira.service;

import java.util.Optional;

import com.joseleonardo.carteira.entity.Usuario;

public interface UsuarioService {

	Usuario salvar(Usuario usuario);
	
	Optional<Usuario> buscarPorEmail(String email);
	
}
