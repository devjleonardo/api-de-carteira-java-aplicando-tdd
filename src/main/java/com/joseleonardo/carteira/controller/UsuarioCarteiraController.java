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

import com.joseleonardo.carteira.dto.UsuarioCarteiraDTO;
import com.joseleonardo.carteira.entity.Carteira;
import com.joseleonardo.carteira.entity.Usuario;
import com.joseleonardo.carteira.entity.UsuarioCarteira;
import com.joseleonardo.carteira.response.Response;
import com.joseleonardo.carteira.service.UsuarioCarteiraService;

@RestController
@RequestMapping("/usuarios/carteiras")
public class UsuarioCarteiraController {

	@Autowired
	private UsuarioCarteiraService usuarioCarteiraService;
	
	@PostMapping
	public ResponseEntity<Response<UsuarioCarteiraDTO>> criar(
			@Valid @RequestBody UsuarioCarteiraDTO dto, BindingResult result){
		Response<UsuarioCarteiraDTO> response = new Response<UsuarioCarteiraDTO>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addError(error.getDefaultMessage()));
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		UsuarioCarteira usuarioCarteira = usuarioCarteiraService.salvar(convertDtoToEntity(dto));
		
		response.setData(convertEntityToDto(usuarioCarteira));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	public UsuarioCarteira convertDtoToEntity(UsuarioCarteiraDTO dto) {
		UsuarioCarteira usuarioCarteira = new UsuarioCarteira();
		
		Usuario usuario = new Usuario();
		usuario.setId(dto.getUsuarioId());
		
		Carteira carteira = new Carteira();
		carteira.setId(dto.getCarteiraId());
		
		usuarioCarteira.setId(dto.getId());
		usuarioCarteira.setUsuario(usuario);
		usuarioCarteira.setCarteira(carteira);
		
		return usuarioCarteira;
	}
	
	public UsuarioCarteiraDTO convertEntityToDto(UsuarioCarteira usuarioCarteira) {
		UsuarioCarteiraDTO dto = new UsuarioCarteiraDTO();
		dto.setId(usuarioCarteira.getId());
		dto.setUsuarioId(usuarioCarteira.getUsuario().getId());
		dto.setCarteiraId(usuarioCarteira.getCarteira().getId());
		
		return dto;
	}
	
}
