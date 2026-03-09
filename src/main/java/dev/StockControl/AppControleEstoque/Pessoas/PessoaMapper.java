package dev.StockControl.AppControleEstoque.Pessoas;

import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public PessoaModel mapToModel (PessoaDTO pessoaDTO) {
        PessoaModel pessoaModel = new PessoaModel();

        pessoaModel.setId(pessoaDTO.getId());
        pessoaModel.setNome(pessoaDTO.getNome());
        pessoaModel.setCpf(pessoaDTO.getCpf());
        pessoaModel.setEndereco(pessoaDTO.getEndereco());
        pessoaModel.setEmail(pessoaDTO.getEmail());

        return pessoaModel;
    }

    public PessoaDTO mapToDto (PessoaModel pessoaModel) {
        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setId(pessoaModel.getId());
        pessoaDTO.setNome(pessoaModel.getNome());
        pessoaDTO.setCpf(pessoaModel.getCpf());
        pessoaDTO.setEndereco(pessoaModel.getEndereco());
        pessoaDTO.setEmail(pessoaModel.getEmail());

        return pessoaDTO;
    }
}
