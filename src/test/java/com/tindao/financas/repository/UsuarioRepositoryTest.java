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

import com.tindao.financas.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest 
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static final String NOME = "teste@teste.com";
	
	@Before
	public void setUp() throws Exception
	{
		Usuario usuario = new Usuario();
		
		usuario.setNome(NOME);
		
		this.usuarioRepository.save(usuario);
	}
	
	@After
	public final void tearDown()
	{
		this.usuarioRepository.deleteAll();
	}
	
	@Test
	public void testBuscarPorNome()
	{
		Usuario usuario = this.usuarioRepository.findByNome(NOME);
		assertEquals(NOME, usuario.getNome());
	}
}
