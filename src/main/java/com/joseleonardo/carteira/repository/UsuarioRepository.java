package com.joseleonardo.carteira.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.joseleonardo.carteira.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
	Optional<Usuario> buscarPorEmail(String email);
	
}
