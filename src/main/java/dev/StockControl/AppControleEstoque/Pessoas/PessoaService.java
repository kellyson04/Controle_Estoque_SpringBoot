package dev.StockControl.AppControleEstoque.Pessoas;

import dev.StockControl.AppControleEstoque.Produtos.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaMapper pessoaMapper;

    public PessoaService(PessoaMapper pessoaMapper, PessoaRepository pessoaRepository) {
        this.pessoaMapper = pessoaMapper;
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaDTO criarPessoa (PessoaDTO novaPessoa) {
        PessoaModel pessoaModel = pessoaMapper.mapToModel(novaPessoa);
        pessoaRepository.save(pessoaModel);

        return novaPessoa;
    }

    public List<PessoaDTO> listaDePessoas () {
        List<PessoaModel> pessoaModels = pessoaRepository.findAll();

        List<PessoaDTO> pessoaDTOS = new ArrayList<>();

        for (PessoaModel cadaPessoa: pessoaModels) {
            pessoaDTOS.add(pessoaMapper.mapToDto(cadaPessoa));
        }

        return pessoaDTOS;
    }

    public PessoaDTO listarPessoaPorID(Long id) {
        PessoaModel pessoaModel = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada para realizar listagem!"));
        return pessoaMapper.mapToDto(pessoaModel);
    }

    public PessoaDTO alterarPessoa(Long id,PessoaDTO novaPessoa) {
        PessoaModel pessoaPraMudar = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada para alteração!."));

        pessoaPraMudar.setNome(novaPessoa.getNome());
        pessoaPraMudar.setEndereco(novaPessoa.getEndereco());
        pessoaPraMudar.setEmail(novaPessoa.getEmail());

        pessoaRepository.save(pessoaPraMudar);
        return pessoaMapper.mapToDto(pessoaPraMudar);
    }

    public void deletarPessoa (Long id) {
        PessoaModel pessoaPraDeletar = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada para deletar!."));
        pessoaRepository.delete(pessoaPraDeletar);
    }

}
