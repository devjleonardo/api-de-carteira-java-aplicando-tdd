package com.joseleonardo.carteira.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joseleonardo.carteira.dto.UsuarioDTO;
import com.joseleonardo.carteira.entity.Usuario;
import com.joseleonardo.carteira.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UsuarioControllerTest {
	
	private static final String NOME = "Usuario Test";
	private static final String SENHA = "123456";
	private static final String EMAIL = "email@teste.com";
	private static final String URL = "/usuarios";
	
	@MockBean
	private UsuarioService usuarioService;
	
	@Autowired
	private MockMvc mockMvc;
	
	public void testSalvar() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post(URL)
				.content(getJsonPayload())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
	
	public Usuario getMockUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome(NOME);
		usuario.setEmail(EMAIL);
		usuario.setSenha(SENHA);
		
		return usuario;
	}
	
	public String getJsonPayload() throws JsonProcessingException {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNome(NOME);
		dto.setEmail(EMAIL);
		dto.setSenha(SENHA);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		return objectMapper.writeValueAsString(dto);
	}

}
