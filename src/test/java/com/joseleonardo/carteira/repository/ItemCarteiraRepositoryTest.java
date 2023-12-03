package com.joseleonardo.carteira.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.joseleonardo.carteira.entity.Carteira;
import com.joseleonardo.carteira.entity.ItemCarteira;
import com.joseleonardo.carteira.entity.enums.TipoItemCarteira;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ItemCarteiraRepositoryTest {

	private static final Date DATA = new Date();
	private static final TipoItemCarteira TIPO = TipoItemCarteira.EN;
	private static final String DESCRICAO = "Conta de Luz";
	private static final BigDecimal VALOR = BigDecimal.valueOf(65);
	private Long idItemCarteiraSalvo = null;
	private Long idCarteiraSalva = null;
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	@Autowired
	private ItemCarteiraRepository itemCarteiraRepository;
	
	@Before
	public void setUp() {
		Carteira carteira = new Carteira();
		carteira.setNome("Carteira Teste");
		carteira.setValor(BigDecimal.valueOf(250));
		
		carteiraRepository.save(carteira);
		
		ItemCarteira itemCarteira = new ItemCarteira(carteira, DATA, TIPO, DESCRICAO, VALOR);
		
		itemCarteiraRepository.save(itemCarteira);
		
		idItemCarteiraSalvo = itemCarteira.getId();
		idCarteiraSalva = carteira.getId();
	}
	
	@After
	public void tearDown() {
		itemCarteiraRepository.deleteAll();
		carteiraRepository.deleteAll();
	}
	
	@Test
	public void testSalvar() {
		Carteira carteira = new Carteira();
		carteira.setNome("Carteira 1");
		carteira.setValor(BigDecimal.valueOf(500));
		
		carteiraRepository.save(carteira);
		
		ItemCarteira itemCarteira = new ItemCarteira(carteira, DATA, TIPO, DESCRICAO, VALOR);
		
		ItemCarteira itemCarteiraSalvo = itemCarteiraRepository.save(itemCarteira);
		
		assertNotNull(itemCarteiraSalvo);
		
		assertEquals(itemCarteiraSalvo.getCarteira(), carteira);
		assertEquals(itemCarteiraSalvo.getData(), DATA);
		assertEquals(itemCarteiraSalvo.getTipo(), TIPO);
		assertEquals(itemCarteiraSalvo.getDescricao(), DESCRICAO);
		assertEquals(itemCarteiraSalvo.getValor(), VALOR);
		
		assertEquals(itemCarteiraSalvo.getCarteira().getId(), carteira.getId());
		
	}
	
	@Test(expected = DataIntegrityViolationException.class)
	public void testSalvarItemCarteiraInvalido() {
		ItemCarteira itemCarteira= new ItemCarteira(null, DATA, null, DESCRICAO, null);
		itemCarteiraRepository.save(itemCarteira);
	}
	
	@Test
	public void testAtualizar() {
		Optional<ItemCarteira> itemCarteiraExistente = itemCarteiraRepository.findById(idItemCarteiraSalvo);
		
		String descricao = "Descrição alterada";
		
		ItemCarteira itemCarteiraAtualizado = itemCarteiraExistente.get();
		itemCarteiraAtualizado.setDescricao(descricao);
		
		itemCarteiraRepository.save(itemCarteiraAtualizado);
		
		Optional<ItemCarteira> novoItemCarteira = itemCarteiraRepository.findById(idItemCarteiraSalvo);
		
		assertEquals(novoItemCarteira.get().getDescricao(), descricao);
	}
	
	@Test
	public void testDeletar() {
		Optional<Carteira> carteira = carteiraRepository.findById(idCarteiraSalva);
		ItemCarteira itemCarteira = new ItemCarteira(carteira.get(), DATA, TIPO, DESCRICAO, VALOR);
		
		itemCarteiraRepository.save(itemCarteira);
		
		itemCarteiraRepository.deleteById(itemCarteira.getId());
		
		Optional<ItemCarteira> itemCarteiraDeletado = itemCarteiraRepository.findById(itemCarteira.getId());
		
		assertFalse(itemCarteiraDeletado.isPresent());
	}
	
}
