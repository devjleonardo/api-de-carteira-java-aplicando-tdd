package com.joseleonardo.carteira.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseleonardo.carteira.dto.UsuarioDTO;
import com.joseleonardo.carteira.entity.Usuario;
import com.joseleonardo.carteira.response.Response;
import com.joseleonardo.carteira.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Response<UsuarioDTO>> criar(
			@Valid @RequestBody UsuarioDTO dto, BindingResult restul) {
		
		Usuario usuario = usuarioService.salvar(convertDtoToEntity(dto));
		
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		response.setData(convertEntityToDto(usuario));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private Usuario convertDtoToEntity(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(dto.getSenha());
		
		return usuario;
	}
	
	private UsuarioDTO convertEntityToDto(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNome(usuario.getNome());
		dto.setEmail(usuario.getEmail());
		dto.setSenha(usuario.getSenha());
		
		return dto;
	}
	
}
