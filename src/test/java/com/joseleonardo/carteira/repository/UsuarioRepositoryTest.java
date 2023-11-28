package com.joseleonardo.carteira.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public interface UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void testSalvar() {
		Usuario usuario = new Usuario();
		usuario.setNome("Teste");
		usuario.setSenha("123456");
		usuario.setEmail("teste@teste.com");
		
		Usuario resposta = usuarioRepository.save(usuario);

		assertNotNull(resposta);
	}
	
}
