package com.joseleonardo.carteira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseleonardo.carteira.entity.UsuarioCarteira;

@Repository
public interface UsuarioCarteiraRepository extends JpaRepository<UsuarioCarteira, Long> {

}
