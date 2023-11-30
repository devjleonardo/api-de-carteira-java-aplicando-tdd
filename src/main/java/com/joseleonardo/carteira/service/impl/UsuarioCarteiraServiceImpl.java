package com.joseleonardo.carteira.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseleonardo.carteira.entity.UsuarioCarteira;
import com.joseleonardo.carteira.repository.UsuarioCarteiraRepository;
import com.joseleonardo.carteira.service.UsuarioCarteiraService;

@Service
public class UsuarioCarteiraServiceImpl implements UsuarioCarteiraService {

	@Autowired
	private UsuarioCarteiraRepository usuarioCarteiraRepository;

	@Override
	public UsuarioCarteira salvar(UsuarioCarteira usuarioCarteira) {
		return usuarioCarteiraRepository.save(usuarioCarteira);
	}
	
}
