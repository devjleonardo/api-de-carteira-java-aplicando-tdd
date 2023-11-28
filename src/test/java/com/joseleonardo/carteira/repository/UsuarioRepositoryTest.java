package com.joseleonardo.carteira.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
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
	
	private static final String EMAIL = "email@teste.com";

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Before
	public void setUp() {
		Usuario usuario = new Usuario();
		usuario.setNome("Set up Usuario");
		usuario.setSenha("Senha123");
		usuario.setEmail(EMAIL);
		
		usuarioRepository.save(usuario);
	}
	
	@After
	public void tearDown() {
		usuarioRepository.deleteAll();
	}
	
	@Test
	public void testSalvar() {
		Usuario novoUsuario = new Usuario();
		novoUsuario.setNome("Teste");
		novoUsuario.setSenha("123456");
		novoUsuario.setEmail("teste@teste.com");
		
		Usuario usuarioSalvo = usuarioRepository.save(novoUsuario);

		assertNotNull(usuarioSalvo);
	}
	
	public void testBuscarPorEmail() {
		Optional<Usuario> usuario = usuarioRepository.buscarPorEmail(EMAIL);
		
		assertTrue(usuario.isPresent());
		assertEquals(usuario.get().getEmail(), EMAIL);
	}
	
}
