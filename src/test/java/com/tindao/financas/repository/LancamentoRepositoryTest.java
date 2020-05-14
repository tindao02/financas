package com.tindao.financas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.tindao.financas.model.Lancamento;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest 
{
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	private static final String DESCRICAO = "Aparelho com defeito, tela não liga.";
	
	@Before
	public void setUp() throws Exception
	{
		Lancamento lancamento = new Lancamento();
		
		lancamento.setDescricao(DESCRICAO);
		
		this.lancamentoRepository.save(lancamento);
	}
	
	@After
	public final void tearDown()
	{
		this.lancamentoRepository.deleteAll();
	}
	
	@Test
	public void testBuscarPorDescricao()
	{
		Lancamento lancamento = this.lancamentoRepository.findByDescricao(DESCRICAO);
		assertEquals(DESCRICAO, lancamento.getDescricao());
	}
}
