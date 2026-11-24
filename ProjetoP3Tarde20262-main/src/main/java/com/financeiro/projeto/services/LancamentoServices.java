package com.financeiro.projeto.services;

import com.financeiro.projeto.dto.DadosCadastroLancamento;
import com.financeiro.projeto.entities.Lancamento;
import com.financeiro.projeto.repositorio.CategoriaRepository;
import com.financeiro.projeto.repositorio.LancamentoRepository;
import com.financeiro.projeto.repositorio.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoServices {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;


    public Lancamento cadastrar(DadosCadastroLancamento dados){

        var categoria = categoriaRepository.getReferenceById(dados.codigoCategoria());

        var pesssoa = pessoaRepository.getReferenceById(dados.codigoPessoa());

        var lancamento =
        new Lancamento(dados, categoria, pesssoa);

        return lancamentoRepository.save(lancamento);

    }

}
