package com.joseleonardo.carteira.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.joseleonardo.carteira.entity.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void testSalvar() {
		Usuario usuario = new Usuario();
		usuario.setNome("Teste");
		usuario.setSenha("123456");
		usuario.setEmail("teste@teste.com");
		
		Usuario resposta = usuarioRepository.save(usuario);

		a(resposta);
	}
	
}
