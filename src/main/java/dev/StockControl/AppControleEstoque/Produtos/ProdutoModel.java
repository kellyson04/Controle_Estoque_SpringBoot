package dev.StockControl.AppControleEstoque.Produtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.StockControl.AppControleEstoque.Pessoas.PessoaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private double valor;

    @Column(name = "quantidade")
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaModel pessoaModel;

}
