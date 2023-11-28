package com.joseleonardo.carteira.service;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.joseleonardo.carteira.entity.Usuario;
import com.joseleonardo.carteira.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

	@MockBean
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Before
	public void setUp() {
		BDDMockito.given(
		        usuarioRepository.buscarPorEmail(
				    Mockito.anyString())).willReturn(Optional.of(new Usuario()));
	}
	
	public void testBuscarPorEmail() {
		Optional<Usuario> usuario = usuarioService.buscarPorEmail("email@teste.com");
		
		assertTrue(usuario.isPresent());
	}
	
}
