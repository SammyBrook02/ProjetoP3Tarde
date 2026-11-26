package com.financeiro.projeto.entities;

import com.financeiro.projeto.dto.DadosAtualizarLancamento;
import com.financeiro.projeto.dto.DadosCadastroLancamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Lancamento")
@Table(name = "lancamento")
@Getter
@NoArgsConstructor
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    private String descricao;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    private BigDecimal valor;
    private String observacao;
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_pessoa", nullable = false)
    private Pessoa pessoa;

    public Lancamento(DadosCadastroLancamento dados, Categoria categoria, Pessoa pessoa) {
        this.descricao = dados.descricao();
        this.dataVencimento = dados.dataVencimento();
        this.dataPagamento = dados.dataPagamento();
        this.valor = dados.valor();
        this.observacao = dados.observacao();
        this.tipo = dados.tipo();
        this.categoria = categoria;
        this.pessoa = pessoa;
    }

    public void atualizarInformacoes(DadosAtualizarLancamento dados,
                                     Categoria categoria, Pessoa pessoa) {
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.dataVencimento() != null) {
            this.dataVencimento = dados.dataVencimento();
        }
        if (dados.dataPagamento() != null) {
            this.dataPagamento = dados.dataPagamento();
        }
        if (dados.valor() != null) {
            this.valor = dados.valor();
        }
        if (dados.observacao() != null) {
            this.observacao = dados.observacao();
        }
        if (dados.tipo() != null) {
            this.tipo = dados.tipo();
        }
        if (categoria != null) {
            this.categoria = categoria;
        }
        if (pessoa != null) {
            this.pessoa = pessoa;
        }
    }
}


