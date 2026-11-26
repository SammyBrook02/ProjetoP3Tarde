package com.financeiro.projeto.services;

import com.financeiro.projeto.dto.DadosAtualizarLancamento;
import com.financeiro.projeto.dto.DadosCadastroLancamento;
import com.financeiro.projeto.dto.DadosDetalhamentoLancamento;
import com.financeiro.projeto.entities.Lancamento;
import com.financeiro.projeto.repositorio.CategoriaRepository;
import com.financeiro.projeto.repositorio.LancamentoRepository;
import com.financeiro.projeto.repositorio.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<DadosDetalhamentoLancamento> listarLancamento(Pageable paginacao) {
        return lancamentoRepository.findAll(paginacao)
        .map(DadosDetalhamentoLancamento::new);
    }

    public Lancamento detalharLancamento(Long id) {
        return lancamentoRepository.getReferenceById(id);
    }

    @Transactional
    public Lancamento atualizarLancamento(DadosAtualizarLancamento dados) {
        var lancamento = lancamentoRepository.getReferenceById(dados.id());
        var categoria = dados.codigoCategoria() != null
                ? categoriaRepository.getReferenceById(dados.codigoCategoria())
                : null;
        var pessoa = dados.codigoPessoa() != null
                ? pessoaRepository.getReferenceById(dados.codigoPessoa())
                : null;

        lancamento.atualizarInformacoes(dados, categoria, pessoa);
        return lancamento;
    }
}
