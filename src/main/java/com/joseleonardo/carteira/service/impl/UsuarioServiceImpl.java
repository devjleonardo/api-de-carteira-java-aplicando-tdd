package com.joseleonardo.carteira.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseleonardo.carteira.entity.Usuario;
import com.joseleonardo.carteira.repository.UsuarioRepository;
import com.joseleonardo.carteira.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> buscarPorEmail(String email) {
		return usuarioRepository.buscarPorEmail(email);
	}

}
