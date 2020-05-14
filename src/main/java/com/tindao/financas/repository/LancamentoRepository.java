package com.tindao.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tindao.financas.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>
{
	@Transactional
	Lancamento findByDescricao(String descricao);
}
