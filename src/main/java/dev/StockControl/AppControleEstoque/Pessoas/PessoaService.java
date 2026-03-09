package dev.StockControl.AppControleEstoque.Pessoas;

import dev.StockControl.AppControleEstoque.Produtos.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaModel criarPessoa (PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }

    public List<PessoaModel> listaDePessoas () {
        return pessoaRepository.findAll();
    }

    public PessoaModel listarPessoaPorID(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada para realizar listagem!"));
    }

    public PessoaModel alterarPessoa(Long id,PessoaModel novaPessoa) {
        PessoaModel pessoaPraMudar = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada para alteração!."));

        pessoaPraMudar.setNome(novaPessoa.getNome());
        pessoaPraMudar.setEndereco(novaPessoa.getEndereco());

        return pessoaRepository.save(pessoaPraMudar);
    }

    public void deletarPessoa (Long id) {
        PessoaModel pessoaPraDeletar = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada para deletar!."));
        pessoaRepository.delete(pessoaPraDeletar);
    }

}
