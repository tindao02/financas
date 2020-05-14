package com.tindao.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tindao.financas.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
	@Transactional(readOnly = true)
	Usuario findByNome(String nome);
}
