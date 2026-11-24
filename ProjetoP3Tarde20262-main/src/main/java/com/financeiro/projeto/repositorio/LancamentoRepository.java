package com.financeiro.projeto.repositorio;

import com.financeiro.projeto.entities.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository  extends JpaRepository<Lancamento, Long> {



}
