package com.joseleonardo.carteira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseleonardo.carteira.entity.Carteira;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

}
