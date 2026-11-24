package com.financeiro.projeto.controller;

import com.financeiro.projeto.dto.DadosCadastroLancamento;
import com.financeiro.projeto.dto.DadosDetalhamentoLancamento;
import com.financeiro.projeto.services.LancamentoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoServices services;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoLancamento> cadastrar(
            @RequestBody @Valid DadosCadastroLancamento dados) {
        var lancamento = services.cadastrar(dados);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new DadosDetalhamentoLancamento(lancamento));
    }
}
