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

import com.joseleonardo.carteira.dto.CarteiraDTO;
import com.joseleonardo.carteira.entity.Carteira;
import com.joseleonardo.carteira.response.Response;
import com.joseleonardo.carteira.service.CarteiraService;

@RestController
@RequestMapping("/carteiras")
public class CarteiraController {

	@Autowired
	private CarteiraService carteiraService;
	
	@PostMapping
	public ResponseEntity<Response<CarteiraDTO>> criar(
			@Valid @RequestBody CarteiraDTO dto, BindingResult result) {
		Response<CarteiraDTO> response = new Response<CarteiraDTO>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addError(error.getDefaultMessage()));
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		Carteira carteira = carteiraService.salvar(convertDtoToEntity(dto));
		
		response.setData(convertEntityToDto(carteira));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private Carteira convertDtoToEntity(CarteiraDTO dto) {
		Carteira carteira = new Carteira();
		carteira.setId(dto.getId());
		carteira.setNome(dto.getNome());
		carteira.setValor(dto.getValor());
		
		return carteira;
	}
	
	private CarteiraDTO convertEntityToDto(Carteira carteira) {
		CarteiraDTO dto = new CarteiraDTO();
		dto.setId(carteira.getId());
		dto.setNome(carteira.getNome());
		dto.setValor(carteira.getValor());
		
		return dto;
	}
	
}
