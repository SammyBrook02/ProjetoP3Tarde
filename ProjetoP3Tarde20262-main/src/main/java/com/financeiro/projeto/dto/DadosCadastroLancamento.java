package com.financeiro.projeto.dto;

import com.financeiro.projeto.entities.TipoLancamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroLancamento(
        @NotBlank String descricao,
        @NotNull LocalDate dataVencimento,
        LocalDate dataPagamento,
        @NotNull @Positive BigDecimal valor,
        String observacao,
        @NotNull TipoLancamento tipo,
        @NotNull Long codigoCategoria,
        @NotNull Long codigoPessoa
) {
}
