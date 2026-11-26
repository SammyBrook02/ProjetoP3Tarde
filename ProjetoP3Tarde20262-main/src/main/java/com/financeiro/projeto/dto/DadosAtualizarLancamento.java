package com.financeiro.projeto.dto;

import com.financeiro.projeto.entities.TipoLancamento;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizarLancamento(
        @NotNull Long id,
        String descricao,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        BigDecimal valor,
        String observacao,
        TipoLancamento tipo,
        Long codigoCategoria,
        Long codigoPessoa
) {}
