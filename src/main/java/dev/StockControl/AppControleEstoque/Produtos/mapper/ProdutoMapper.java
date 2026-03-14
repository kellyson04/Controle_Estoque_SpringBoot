package dev.StockControl.AppControleEstoque.Produtos.mapper;

import dev.StockControl.AppControleEstoque.Produtos.dto.ProdutoDTO;
import dev.StockControl.AppControleEstoque.Produtos.model.ProdutoModel;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoModel mapToModel(ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = new ProdutoModel();

        produtoModel.setId(produtoDTO.getId());
        produtoModel.setNome(produtoDTO.getNome());
        produtoModel.setValor(produtoDTO.getValor());
        produtoModel.setQuantidade(produtoDTO.getQuantidade());
        produtoModel.setPessoaModel(produtoDTO.getPessoaModel());

        return produtoModel;
    }

    public ProdutoDTO mapToDto(ProdutoModel produtoModel) {
        ProdutoDTO produtoDTO = new ProdutoDTO();

        produtoDTO.setId((produtoModel.getId()));
        produtoDTO.setNome(produtoModel.getNome());
        produtoDTO.setValor(produtoModel.getValor());
        produtoDTO.setQuantidade(produtoModel.getQuantidade());
        produtoDTO.setPessoaModel(produtoModel.getPessoaModel());

        return produtoDTO;
    }
}
