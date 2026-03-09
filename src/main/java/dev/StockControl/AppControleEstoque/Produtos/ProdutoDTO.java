package dev.StockControl.AppControleEstoque.Produtos;

import dev.StockControl.AppControleEstoque.Pessoas.PessoaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;

    private String nome;

    private double valor;

    private int quantidade;

    private PessoaModel pessoaModel;

}
