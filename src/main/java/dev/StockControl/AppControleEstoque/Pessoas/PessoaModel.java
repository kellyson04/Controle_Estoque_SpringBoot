package dev.StockControl.AppControleEstoque.Pessoas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.StockControl.AppControleEstoque.Produtos.ProdutoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_pessoas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(name = "endereço")
    private String endereco;

    @OneToMany(mappedBy = "pessoaModel")
    @JsonIgnore
    private List<ProdutoModel> produtoModel;

}
