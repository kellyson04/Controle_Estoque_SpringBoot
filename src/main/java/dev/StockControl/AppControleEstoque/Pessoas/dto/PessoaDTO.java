package dev.StockControl.AppControleEstoque.Pessoas.dto;

import dev.StockControl.AppControleEstoque.Produtos.model.ProdutoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Long id;

    private String nome;

    private String cpf;

    private String endereco;

    private String email;

    private List<ProdutoModel> produtoModel;
}
