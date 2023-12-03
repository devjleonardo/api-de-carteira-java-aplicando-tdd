package com.joseleonardo.carteira.repository;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.joseleonardo.carteira.entity.Carteira;
import com.joseleonardo.carteira.entity.ItemCarteira;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ItemCarteiraRepositoryTest {

	private static final Date DATA = new Date();
	private static final String TIPO = "ENTRADA";
	private static final String DESCRICAO = "Conta de luz";
	private static final BigDecimal VALOR = BigDecimal.valueOf(65);
	
	@Autowired
	private ItemCarteiraRepository itemCarteiraRepository;
	
	@Test
	public void testSalvar() {
		Carteira carteira = new Carteira();
		carteira.setNome("Carteria 1");
		carteira.setValor(BigDecimal.valueOf(500));
		
		ItemCarteira novoItemCarteira = new ItemCarteira(carteira, DATA, TIPO, DESCRICAO, VALOR);
		
		ItemCarteira itemCarteiraSalvo = itemCarteiraRepository.save(novoItemCarteira);
		
		assertNotNull(itemCarteiraSalvo);
	}
	
}
