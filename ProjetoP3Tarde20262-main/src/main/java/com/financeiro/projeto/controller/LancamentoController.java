package com.financeiro.projeto.controller;

import com.financeiro.projeto.dto.DadosAtualizarLancamento;
import com.financeiro.projeto.dto.DadosCadastroLancamento;
import com.financeiro.projeto.dto.DadosDetalhamentoLancamento;
import com.financeiro.projeto.services.LancamentoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoLancamento>> listar(
            @PageableDefault(size = 10, sort = {"id"})Pageable paginacao) {
        Page<DadosDetalhamentoLancamento> page = services.listarLancamento(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("{/id}")
    public ResponseEntity<DadosDetalhamentoLancamento> detalhar(@PathVariable Long id){
        var lancamento = services.detalharLancamento(id);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }

    @PutMapping
    public ResponseEntity<DadosDetalhamentoLancamento> atualizar(
            @RequestBody @Valid DadosAtualizarLancamento dados) {
        var lancamento = services.atualizarLancamento(dados);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));

    }







}
