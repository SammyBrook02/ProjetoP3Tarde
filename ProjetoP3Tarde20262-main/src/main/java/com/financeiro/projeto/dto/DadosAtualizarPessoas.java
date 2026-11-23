package com.financeiro.projeto.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPessoas(
        @NotNull
        Long Id,
        String nome,
        DadosEndereco endereco

) {
}
