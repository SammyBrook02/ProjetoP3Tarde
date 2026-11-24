package com.financeiro.projeto.dto;

import com.financeiro.projeto.entities.Lancamento;
import com.financeiro.projeto.entities.TipoLancamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosDetalhamentoLancamento(
        Long codigo,
        String descricao,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        BigDecimal valor,
        String observacao,
        TipoLancamento tipo,
        Long codigoCategoria,
        Long codigoPessoa
) {
    public DadosDetalhamentoLancamento
            (Lancamento lancamento) {
        this(
                lancamento.getCodigo(),
                lancamento.getDescricao(),
                lancamento.getDataVencimento(),
                lancamento.getDataPagamento(),
                lancamento.getValor(),
                lancamento.getObservacao(),
                lancamento.getTipo(),
                lancamento.getCategoria().getId(),
                lancamento.getPessoa().getId()
        );
    }
}
