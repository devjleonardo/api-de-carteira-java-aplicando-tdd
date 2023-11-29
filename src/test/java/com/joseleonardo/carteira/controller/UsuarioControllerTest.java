package com.joseleonardo.carteira.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
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
	
	private static final Long ID = 1L;
	private static final String NOME = "Usuario Test";
	private static final String EMAIL = "email@teste.com";
	private static final String SENHA = "123456";
	private static final String URL = "/usuarios";
	
	@MockBean
	private UsuarioService usuarioService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testSalvar() throws JsonProcessingException, Exception {
		BDDMockito.given(
				usuarioService.salvar(
				    Mockito.any(Usuario.class))).willReturn(getMockUsuario());
		
		mockMvc.perform(MockMvcRequestBuilders.post(URL)
				.content(getJsonPayload(ID, NOME, EMAIL, SENHA))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.data.id").value(ID))
				.andExpect(jsonPath("$.data.nome").value(NOME))
				.andExpect(jsonPath("$.data.email").value(EMAIL))
				.andExpect(jsonPath("$.data.senha").value(SENHA));
	}
	
	@Test
	public void testSalvarUsuarioInvalido() throws JsonProcessingException, Exception {
		mockMvc.perform(MockMvcRequestBuilders.post(URL)
				.content(getJsonPayload(ID, NOME, "email", SENHA))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors[0]").value("Email inválido"));
	}
	
	public Usuario getMockUsuario() {
		Usuario usuario = new Usuario();
		usuario.setId(ID);
		usuario.setNome(NOME);
		usuario.setEmail(EMAIL);
		usuario.setSenha(SENHA);
		
		return usuario;
	}
	
	public String getJsonPayload(Long id, String nome, String email, String senha) throws JsonProcessingException {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(id);
		dto.setNome(nome);
		dto.setEmail(email);
		dto.setSenha(senha);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		return objectMapper.writeValueAsString(dto);
	}

}
