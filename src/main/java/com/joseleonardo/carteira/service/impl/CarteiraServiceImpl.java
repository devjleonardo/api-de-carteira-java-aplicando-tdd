package com.joseleonardo.carteira.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseleonardo.carteira.entity.Carteira;
import com.joseleonardo.carteira.repository.CarteiraRepository;
import com.joseleonardo.carteira.service.CarteiraService;

@Service
public class CarteiraServiceImpl implements CarteiraService {

	@Autowired
	private CarteiraRepository carteiraRepository;
	
	@Override
	public Carteira salvar(Carteira carteira) {
		return carteiraRepository.save(carteira);
	}

}
